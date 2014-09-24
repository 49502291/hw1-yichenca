	package src.main.java;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.tcas.DocumentAnnotation;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;
import org.apache.uima.util.ProgressImpl;

public class CollectionReader extends CollectionReader_ImplBase {

	  public static final String PARAM_INPUTDIR = "InputDirectory";
	  public static final String PARAM_SUBDIR = "BrowseSubdirectories";

	  private ArrayList<String> sentences;
	  private int mCurrentIndex;
	  private ArrayList<File> mFiles;
	  
	  private Boolean mRecursive;
	  
	  /**
	   * This method sets configuration parameters and perform other initialization logic.
	   * And according to this project requirement,  the method will only read the first file from the given directory
	   * Then it will call readFile function to read line from file and store each sentence in ArrayList<String> sentences 
	   *  
	   * @param directory
	   * @param file
	   */
	  
	 public void initialize() throws ResourceInitializationException {
	    
		File directory = new File(((String) getConfigParameterValue(PARAM_INPUTDIR)).trim());		 
	    
	    mRecursive = (Boolean) getConfigParameterValue(PARAM_SUBDIR);
	    if (null == mRecursive) { // could be null if not set, it is optional
	      mRecursive = Boolean.FALSE;
	    }
	    	
	    mCurrentIndex = 0;
	    
	    // if input directory does not exist or is not a directory, throw exception
	    if (!directory.exists() || !directory.isDirectory()) {
	      throw new ResourceInitializationException(ResourceConfigurationException.DIRECTORY_NOT_FOUND,
	              new Object[] { PARAM_INPUTDIR, this.getMetaData().getName(), directory.getPath() });
	    }

	    // get list of files in the specified directory, and subdirectories if the
	    // parameter PARAM_SUBDIR is set to True
	    mFiles = new ArrayList<File>();
	    addFilesFromDir(directory);
	    
	    File file = (File) mFiles.get(0);
	    
	    try {
			sentences = readFile(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	  }
	 
	 /**
	   * This method adds files in the directory passed in as a parameter to mFiles.
	   * If mRecursive is true, it will include all files in all
	   * subdirectories (recursively), as well. 
	   * 
	   * @param dir
	   */
	  private void addFilesFromDir(File dir) {
	    File[] files = dir.listFiles();
	    for (int i = 0; i < files.length; i++) {
	      if (!files[i].isDirectory()) {
	        mFiles.add(files[i]);
	      } else if (mRecursive) {
	        addFilesFromDir(files[i]);
	      }
	    }
	  }
	  /**
	   * This method reads each line from file and stores sentences in ArrayList
	   * 
	   * @param filename
	   */
	  
	
	 	private ArrayList<String> readFile(File filename) throws Exception
			 {
			     String line = null;
			     ArrayList<String> records = new ArrayList<String>();
			  
			     BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			  
			     // use the readLine method of the BufferedReader to read one line at a time.
			     while ((line = bufferedReader.readLine()) != null)
			     {
			         records.add(line);
			     }
			    
			     bufferedReader.close();
			     return records;
			 }
	  /**
	 	*  This method gets a sentence each time, and splits this sentence to put id 
	 	*  and text into annotation,respectively. 
	 	*/
	 		
	@Override
	public void getNext(CAS aCAS) throws IOException, CollectionException {
		JCas jcas;
	    try {
	      jcas = aCAS.getJCas();
	    } catch (CASException e) {
	      throw new CollectionException(e);
	    }

	    // open input stream to file
	    String sentence = sentences.get(mCurrentIndex++);
	    
	    Text annotation =new Text(jcas);
	      // put document in CAS
	    int value=0;
		
		for(int j =0;j<sentence.length();j++)
		{
			if(sentence.charAt(j)==' ')
			{ 
				value=j;
				break;
			}
		}
		annotation.setID(sentence.substring(0, value));
		annotation.setSentence(sentence.substring(value+1, sentence.length()));
		annotation.addToIndexes();
	    	    
	}

	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Progress[] getProgress() {
	return new Progress[] { new ProgressImpl(mCurrentIndex, sentences.size(), Progress.ENTITIES) };		
	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		return mCurrentIndex < sentences.size();
	}
	

	

}
