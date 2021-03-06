

/* First created by JCasGen Mon Sep 22 16:31:56 EDT 2014 */
package src.main.java;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Sep 24 15:11:47 EDT 2014
 * XML source: /Users/seven/git/hw1-yichenca/hw1-yichenca/src/main/resources/descriptors/typeSystemDescriptor.xml
 * @generated */
public class Text extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Text.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated
   * @return index of the type  
   */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Text() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Text(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Text(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Text(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** 
   * <!-- begin-user-doc -->
   * Write your own initialization here
   * <!-- end-user-doc -->
   *
   * @generated modifiable 
   */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (Text_Type.featOkTst && ((Text_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "src.main.java.Text");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Text_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (Text_Type.featOkTst && ((Text_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "src.main.java.Text");
    jcasType.ll_cas.ll_setStringValue(addr, ((Text_Type)jcasType).casFeatCode_ID, v);}    
   
    
  //*--------------*
  //* Feature: Sentence

  /** getter for Sentence - gets 
   * @generated
   * @return value of the feature 
   */
  public String getSentence() {
    if (Text_Type.featOkTst && ((Text_Type)jcasType).casFeat_Sentence == null)
      jcasType.jcas.throwFeatMissing("Sentence", "src.main.java.Text");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Text_Type)jcasType).casFeatCode_Sentence);}
    
  /** setter for Sentence - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setSentence(String v) {
    if (Text_Type.featOkTst && ((Text_Type)jcasType).casFeat_Sentence == null)
      jcasType.jcas.throwFeatMissing("Sentence", "src.main.java.Text");
    jcasType.ll_cas.ll_setStringValue(addr, ((Text_Type)jcasType).casFeatCode_Sentence, v);}    
  }

    