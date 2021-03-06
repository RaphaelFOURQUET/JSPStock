/**
 * 
 */
package fr.adaming.constante;

/**
 * @author INTI-0332
 *
 */
public class Constante {
	
	//Nom formulaires
	public static final String KEY_CONNECTED_USER = "utilisateurConnecte";
	public static final String PARAM_USER_LOGIN = "utilisateur";
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String PRODUIT = "produit";
	public static final String LOGO = "logo";
	public static final String LAST_EDITED_PRODUCT = "lastEditedProduct";
	
	//Paths
	public static final String XML_PATH = "C:/Cours/GitHub/JSPStock/JSPStock/src/fr/adaming/persistance/xml";
	public static final String URL_HOME = "index.jsp";
	
	//interface materialize
	//RFRF : necessite un clean tomcat à chaque changement.
	public static final String COL_SIZE = "input-field col s6";
	public static final String BUTTON_COLOR = "red lighten-2 btn waves-effect waves-light";
	
	public static final boolean DISABLED = true;	//RFRF : try dynamic <> attributes
	
	//Persistance mode
	public static final ModePersistance PERSISTANCE_MODE = ModePersistance.XML;

}
