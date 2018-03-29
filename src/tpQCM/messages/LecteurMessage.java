package tpQCM.messages;

import java.util.ResourceBundle;

public class LecteurMessage {
	/**
	 * Cette classe permet de lire le contenu du fichier messages_erreur.properties
	 * @author Administrator
	 *
	 */
	private static ResourceBundle rb;
		
		static
		{
			try
			{
				rb = ResourceBundle.getBundle("tpQCM.messages.messages_erreur");
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		
		private LecteurMessage()
		{
			
		}
		
	/**
	* @param code
	* @return
	*/
	public static  String getMessageErreur(int code)
	{
			String message="";
			try
			{
				if(rb!=null)
				{
					message = rb.getString(String.valueOf(code));
				}
				else
				{
					message="Problème à la lecture du fichier contenant les messages";
				}
			}
			catch (Exception e) {
				e.printStackTrace();
				message="Une erreur inconnue est survenue";
			}
			System.out.println("message="+message);
			return message;
	}
}

