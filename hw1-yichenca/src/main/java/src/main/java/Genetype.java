

/* First created by JCasGen Sun Sep 21 11:57:59 EDT 2014 */
package src.main.java;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Wed Sep 24 15:11:47 EDT 2014
 * XML source: /Users/seven/git/hw1-yichenca/hw1-yichenca/src/main/resources/descriptors/typeSystemDescriptor.xml
 * @generated */
public class Genetype extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Genetype.class);
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
  protected Genetype() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated
   * @param addr low level Feature Structure reference
   * @param type the type of this Feature Structure 
   */
  public Genetype(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated
   * @param jcas JCas to which this Feature Structure belongs 
   */
  public Genetype(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated
   * @param jcas JCas to which this Feature Structure belongs
   * @param begin offset to the begin spot in the SofA
   * @param end offset to the end spot in the SofA 
  */  
  public Genetype(JCas jcas, int begin, int end) {
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
  //* Feature: Gene

  /** getter for Gene - gets 
   * @generated
   * @return value of the feature 
   */
  public String getGene() {
    if (Genetype_Type.featOkTst && ((Genetype_Type)jcasType).casFeat_Gene == null)
      jcasType.jcas.throwFeatMissing("Gene", "src.main.java.Genetype");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Genetype_Type)jcasType).casFeatCode_Gene);}
    
  /** setter for Gene - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setGene(String v) {
    if (Genetype_Type.featOkTst && ((Genetype_Type)jcasType).casFeat_Gene == null)
      jcasType.jcas.throwFeatMissing("Gene", "src.main.java.Genetype");
    jcasType.ll_cas.ll_setStringValue(addr, ((Genetype_Type)jcasType).casFeatCode_Gene, v);}    
   
    
  //*--------------*
  //* Feature: ID

  /** getter for ID - gets 
   * @generated
   * @return value of the feature 
   */
  public String getID() {
    if (Genetype_Type.featOkTst && ((Genetype_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "src.main.java.Genetype");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Genetype_Type)jcasType).casFeatCode_ID);}
    
  /** setter for ID - sets  
   * @generated
   * @param v value to set into the feature 
   */
  public void setID(String v) {
    if (Genetype_Type.featOkTst && ((Genetype_Type)jcasType).casFeat_ID == null)
      jcasType.jcas.throwFeatMissing("ID", "src.main.java.Genetype");
    jcasType.ll_cas.ll_setStringValue(addr, ((Genetype_Type)jcasType).casFeatCode_ID, v);}    
  }

    