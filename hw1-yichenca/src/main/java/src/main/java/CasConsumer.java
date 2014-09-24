package src.main.java;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedWriter;
import java.io.FileWriter;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.cas.impl.XCASSerializer;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;
import org.apache.uima.util.XMLSerializer;
import org.xml.sax.SAXException;


public class CasConsumer extends CasConsumer_ImplBase {

	  public static final String PARAM_OUTPUTDIR = "OutputDirectory";

	  private File mOutputDir;
	  private BufferedWriter write;

	  /**
	   * This method sets configuration parameters, mainly for write file and perform other initialization logic.
	   *  
	   * @param mOutputDir
	   * 
	   */
	  
	  
	  public void initialize() throws ResourceInitializationException {
		  
		    mOutputDir = new File((String) getConfigParameterValue(PARAM_OUTPUTDIR));
		    if (!mOutputDir.exists()) {
		      mOutputDir.mkdirs();
		    }
		    String aa = mOutputDir.getPath();
		   
		    try {
				write = new BufferedWriter (new FileWriter(aa+"/hw1-yichenca.out"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		  }
	  
	  /**
	   * This method reads annotation from annotator, and call function Write2File to write annotation's features to file
	   *  
	   */
	  
	  public void processCas(CAS aCAS) throws ResourceProcessException {
		    JCas jcas;
		    try {
		      jcas = aCAS.getJCas();
		    } catch (CASException e) {
		      throw new ResourceProcessException(e);
		    }

		    FSIterator it = jcas.getAnnotationIndex(Genetype.type).iterator();
		    File outFile = null;
		    
		    while(it.hasNext())
		    {
		    	Genetype annotation = (Genetype)it.next();
		    	
		    	try {
					Write2File(annotation.getBegin(), annotation.getEnd(),annotation.getID(), annotation.getGene());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	
		    }
	  }
	  
	  /**
	   * This method writes annotation's features to given output file.
	   * @param start
	   * @param end
	   * @param ID
	   * @param gene
	   *  
	   */
	  
	  
	  public void Write2File(int start, int end, String ID, String gene) throws Exception 
	  {
		  
		  String out = ID+"|"+start+" "+ end + "|"+gene;
		  write.write(out);
		  write.newLine();
		  write.flush();
		  
	  }
	  
	  public void collectionProcessComplete(ProcessTrace arg0) throws ResourceProcessException,IOException
	  {
		  write.close();
	  }


}
