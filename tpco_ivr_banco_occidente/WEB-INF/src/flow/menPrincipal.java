package flow;

import com.avaya.sce.runtimecommon.SCESession;
import com.tp.utils.CustomTracking;
import com.tp.utils.Utils;

/**
 * Class that represents a menu.  A menu can contain prompts, choices and links
 * as well as handlers for various events that may occur while the menu is executing
 * Last generated by Orchestration Designer at: NOVEMBER 13, 2019 3:23:53 PM COT
 */
public class menPrincipal extends com.avaya.sce.runtime.Menu {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: NOVEMBER 13, 2019 3:23:53 PM COT
	 */
	public menPrincipal() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		setNeedsDefaultDisconnectHandler(false);
		//}}END:CLASS:CONSTRUCTOR
	}

	@Override
	public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		try{		
			Utils.agregarOpcion("MenuPrincipal", "Menú Principal", mySession, "", "", "", "", "9", "5");
		}catch(Exception ex){
			CustomTracking.error(mySession, ex.getMessage());
		}
	}

	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the links for the node, override:
	 *     void updateLinks(Collection links, SCESession mySession)
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 * @return a collection of links
	 */
	public java.util.Collection getLinks(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Link link;
		java.util.List list;
		java.util.Collection grammarInfo = null;
		java.util.Collection<com.avaya.sce.runtime.CaptureExpression> captureExpr = null;
		// This item does not have any defined links
		list = new java.util.ArrayList();
		String ___tempGrammarName = null;

		return(list);
	}
	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the properties for the node, override:
	 *     void updateProperties(Collection properties, SCESession mySession)
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 * @return a collection of properties
	 */
	public java.util.Collection getProperties(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Property property;
		java.util.List list;
		// This item does not have any defined properties
		list = new java.util.ArrayList();

		return(list);
	}
	/**
	 * This method is generated automatically and should not be manually edited.
	 * To manually edit the event handlers for the node, override:
	 *    void updateEvents(Collection events, SCESession mySession)
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 * @return a collection of Events
	 */
	public java.util.Collection getEvents(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list;
		com.avaya.sce.runtime.Event event;
		list = new java.util.ArrayList(2);
		java.util.List eventPromptNames = null;
		String ___tempPromptName = null;

		// Item has no prompts associated
		eventPromptNames = new java.util.ArrayList();

		event = new com.avaya.sce.runtime.Event(com.avaya.sce.runtimecommon.SCERT.EVENT_NOINPUT, (com.avaya.sce.runtime.PromptRefInfo[])eventPromptNames.toArray(new com.avaya.sce.runtime.PromptRefInfo[0]), new com.avaya.sce.runtime.Goto("codMenuPrincipal", 0, true, ""));
		list.add(event);

		// Item has no prompts associated
		eventPromptNames = new java.util.ArrayList();

		event = new com.avaya.sce.runtime.Event(com.avaya.sce.runtimecommon.SCERT.EVENT_NOMATCH, (com.avaya.sce.runtime.PromptRefInfo[])eventPromptNames.toArray(new com.avaya.sce.runtime.PromptRefInfo[0]), new com.avaya.sce.runtime.Goto("codMenuPrincipal", 0, true, ""));
		list.add(event);
		return(list);
	}
	/**
	 * Builds the list of choices for the menu.  This list is built
	 * automatically by the code generator and should not be edited
	 * manually.  Future code generation may overwrite any changes
	 * to this method.<br>
	 * To modify the list of choices, override:<br>
	 *    updateChoices(Collection choices, SCESession mySession)
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection getChoices(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		com.avaya.sce.runtime.Choice choice = null;
		java.util.Collection grammarInfo = null;
		list = new java.util.ArrayList(9);
		String ___tempGrammarName = null;

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Cancelar Seguro", "1", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Información Seguro", "2", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Radicar petición queja o reclamo", "3", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Reportar y/o solicitar informacion del siniestro", "4", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Solicitar asistencia o información de su ecosistema", "5", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Solicitar asistencia vive la vida", "6", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Solicita una asistencia e Contenidos para el Hogar", "7", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Reportar el cambio de actividad económica", "8", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		// build the list of grammar information objects for the choice
		grammarInfo = new java.util.ArrayList();


		choice = new com.avaya.sce.runtime.Choice("Repetir menu", "9", true, "exact", "codMenuPrincipal", grammarInfo, true);
		list.add(choice);

		return(list);
	}
	/**
	 * Builds the list of prompts that are used by this flow item<br>
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.  To modify the list
	 * of prompts for the flow item, override:
	 *     updatePrompts(Collection prompts, SCESession mySession)
	 * @return list of prompts for the menu
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection getPrompts(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;
		String ___tempPromptName = null;
		// build the list of prompt names
		list = new java.util.ArrayList(1);
		
		list.add(new com.avaya.sce.runtime.PromptRefInfo("prmMenuPrincipal", ""));

		return(list);
	}
	/**
	 * Builds the list of tracking items that are generated by this flow item<br>
	 * This method is generated automatically and changes to it may
	 * be overwritten next time code is generated.
	 * @return list of tracking items for the item
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection getTrackingActions(com.avaya.sce.runtimecommon.SCESession mySession) {
		java.util.List list = null;

		// Item has no tracking items.
		list = new java.util.ArrayList();
		return(list);
	}
	
}
