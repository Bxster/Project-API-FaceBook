package univpm.social.model;

import java.util.Date;

/**
 * Questa interfaccia prepara i metodi del modello
 * 
 * @author Baldelli Gianluca
 * @author Bellante Luca
 *
 */

public interface Model {
	
	/**
	 * Metodo che restituisce la data di creazione dell'oggetto
     */
	public String getCreatedTime();
	/**
     * Metodo che restituisce il nome dell'oggetto chiamando il metodo
     * della superclasse
     */
	public String getName();
	/**
	 * Metodo toDate che converte la stringa della data in un
	 * elemento Iso
	 */
	public Date toDate();
	/**
     * Metodo che restituisce l'id dell'oggetto chiamando il metodo
     * della superclasse
     */
    public String getId();

}
