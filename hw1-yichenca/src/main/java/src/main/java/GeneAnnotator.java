package src.main.java;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.jcas.tcas.Annotation;

import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.chunk.Chunk;
import com.aliasi.util.AbstractExternalizable;

import java.io.File;
import java.io.IOException;


public class GeneAnnotator extends JCasAnnotator_ImplBase {

	
	 /**
	   * This method uses LingPipe to recognize entities. The named entity recognition mainly
	   * involves a statistical named entity recognizer.
	   * Then put recognized gene, and its id, start point, end point into annotation,respectively
	   */
	
	@Override
	public void process(JCas aJcas) throws AnalysisEngineProcessException {
		
	String id = "";
	String sentence ="";
	Chunking chunking =null;
	Chunker chunker =null;
	FSIterator<Annotation> it =aJcas.getAnnotationIndex(Text.type).iterator();
	
	File modelFile = new File("./src/main/resources/ne-en-bio-genetag.HmmChunker");

	System.out.println("Reading chunker from file=" + modelFile);
	
	try {
		chunker  = (Chunker) AbstractExternalizable.readObject(modelFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
	while(it.hasNext())
	{
		Text annotation = (Text) it.next();
		id = annotation.getID();
		sentence = annotation.getSentence();
		chunking=chunker.chunk(sentence);
		
		for(Chunk chunk : chunking.chunkSet())
		{
			Genetype gene = new Genetype(aJcas);

			String temp = sentence.substring(0, chunk.start());
			String words =sentence.substring(chunk.start(),chunk.end());
			int gap1 = countspaces(temp);
			int gap2 =countspaces(words);
			
			gene.setID(id);
			gene.setBegin(chunk.start()-gap1);
			gene.setEnd(chunk.end()-gap1-gap2-1);
			gene.setGene(words);
			gene.addToIndexes();
		}
		
	} 
	
	}
	
	int countspaces(String s)
	{
		int value =0;
		for (int i =0; i<s.length(); i++)
		{
			if(s.charAt(i)==' ')
			{
				value++;
			}
		}
		return value;
	}
	
}
