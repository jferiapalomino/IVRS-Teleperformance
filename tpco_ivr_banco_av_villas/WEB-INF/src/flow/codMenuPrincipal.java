package flow;

import com.avaya.sce.runtimecommon.SCESession;
import com.tp.utils.CustomTracking;
import com.tp.utils.Utils;

/**
 * The Data class handles many types of server-side operations including data
 * collection (from a data sources such as a database, or web service), variable
 * assignments and operations (like copying variable values, performing mathematic
 * operations, and collection iteration), conditional evaluation to control callflow
 * execution based on variable values, and logging/tracing statements.
 * 
 * Items created in the getDataActions() method are executed/evaluated in order
 * and if a condional branch condition evaluates to "true" then the branch is
 * activated and the execution of data actions is halted.  If no "true" conditions
 * are encountered, then all data actions will be executed/evaluated and the 
 * application will proceed to the "Default" servlet.
 * Last generated by Orchestration Designer at: NOVEMBER 13, 2019 2:36:46 PM COT
 */
public class codMenuPrincipal extends com.avaya.sce.runtime.Data {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Default constructor
	 * Last generated by Orchestration Designer at: NOVEMBER 13, 2019 2:36:46 PM COT
	 */
	public codMenuPrincipal() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}
	
	@Override
	public void requestBegin(SCESession mySession) {
		// TODO Auto-generated method stub
		super.requestBegin(mySession);
		try{		
			String value = mySession.getVariableField(IProjectVariables.MEN_PRINCIPAL,IProjectVariables.MEN_PRINCIPAL_FIELD_VALUE).getStringValue();
			int NoInput = mySession.getVariableField(IProjectVariables.MEN_PRINCIPAL,IProjectVariables.MEN_PRINCIPAL_FIELD_NOINPUTCOUNT).getIntValue();
			int NoMatch = mySession.getVariableField(IProjectVariables.MEN_PRINCIPAL,IProjectVariables.MEN_PRINCIPAL_FIELD_NOMATCHCOUNT).getIntValue();
			int Repeticiones = mySession.getVariableField(IProjectVariables.VAR_CONFIGURACION,IProjectVariables.VAR_CONFIGURACION_FIELD_REPETICIONES).getIntValue();
			
			int IntentosMenu = mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().getIntValue();
			IntentosMenu = IntentosMenu + 1;
			mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue(IntentosMenu);


			if(NoInput >= 1) {
				Utils.agregarOpcion("NoInput", "No ingreso opción - Menu Principal", mySession, "", "", "", "", "9", "5");				
			}else {
				if (NoMatch >= 1) {
					Utils.agregarOpcion("NoMatch", "Opción no valida - Menu Principal", mySession, "", "", "", "", "9", "5");							
				}else {	
					switch (value) {
					case "1":
						mySession.getVariable(IProjectVariables.OPCION_MENU).getSimpleVariable().setValue("1. Para solicitar la desactivación de su seguro");
						Utils.agregarOpcion("Opcion1", "Opción 1 - Para solicitar la desactivación de su seguro", mySession, "", "", "", "1", "9", "5");
						mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue("0");
						break;
					case "2":
						mySession.getVariable(IProjectVariables.OPCION_MENU).getSimpleVariable().setValue("2. Para información de su seguro");
						Utils.agregarOpcion("Opcion2", "Opción 2 - Para información de su seguro", mySession, "", "", "", "2", "9", "5");
						mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue("0");
						break;
					case "3":
						mySession.getVariable(IProjectVariables.OPCION_MENU).getSimpleVariable().setValue("3. Para radicar una petición queja o reclamo");
						Utils.agregarOpcion("Opcion3", "Opción 3 - Para radicar una petición queja o reclamo", mySession, "", "", "", "3", "9", "5");
						mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue("0");
						break;
					case "4":
						mySession.getVariable(IProjectVariables.OPCION_MENU).getSimpleVariable().setValue("4. Para reportar y/o solicitar información del estado de su siniestro");
						Utils.agregarOpcion("Opcion4", "Opción 4 - Para reportar y/o solicitar información del estado de su siniestro", mySession, "", "", "", "4", "9", "5");
						mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue("0");
						break;
					case "5":
						mySession.getVariable(IProjectVariables.OPCION_MENU).getSimpleVariable().setValue("5.  Para solicitar una asistencia o si requiere información de su ecosistema de servicio ");
						Utils.agregarOpcion("Opcion5", "Opción 5 -  Para solicitar una asistencia o si requiere información de su ecosistema de servicio", mySession, "", "", "", "5", "9", "5");
						mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue("0");
						break;
					case "8":
						mySession.getVariable(IProjectVariables.OPCION_MENU).getSimpleVariable().setValue("8. Para reportar el cambio de actividad económica en su seguro cuota protegida");
						Utils.agregarOpcion("Opcion8", "Opción 8 - Para reportar el cambio de actividad económica en su seguro cuota protegida", mySession, "", "", "", "8", "9", "5");
						mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue("0");
						break;
					case "9":
						mySession.getVariable(IProjectVariables.OPCION_MENU).getSimpleVariable().setValue("9. Repetir menú");
						Utils.agregarOpcion("Opcion9", "Opción 9 - Repetir menú", mySession, "", "", "", "9", "9", "5");
						mySession.getVariable(IProjectVariables.INTENTOS_MENU).getSimpleVariable().setValue("0");
						break;
				}
				}
			}
			
			if(IntentosMenu >= Repeticiones) {
				Utils.agregarOpcion("ExcedeIntentos", "Excede intentos - Menu Principal", mySession, "", "", "", "", "9", "5");
			}
		}catch(Exception ex){
			CustomTracking.error(mySession, ex.getMessage());
		}
	}

	/**
	 * Returns the Next item which will forward application execution
	 * to the next form in the call flow.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public com.avaya.sce.runtime.Next getNext(com.avaya.sce.runtimecommon.SCESession mySession) {
		com.avaya.sce.runtime.Next next = null;
		return next;
	}
	/**
	 * Create a list of local variables used by items in the data node.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public java.util.Collection<VariableInfo> getLocalVariables(){
		java.util.Collection<VariableInfo> variables = new java.util.ArrayList<VariableInfo>();

		return variables;
	}
	/**
	 * Creates and conditionally executes operations that have been configured
	 * in the Callflow.  This method will build a collection of operations and
	 * have the framework execute the operations by calling evaluateActions().
	 * If the evaluation causes the framework to forward to a different servlet
	 * then execution stops.
	 * Returning true from this method means that the framework has forwarded the
	 * request to a different servlet.  Returning false means that the default
	 * Next will be invoked.
	 * 
	 * This method is generated automatically by the code generator
	 * and should not be manually edited.  Manual edits may be overwritten
	 * by the code generator.
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public boolean executeDataActions(com.avaya.sce.runtimecommon.SCESession mySession) throws Exception {
		java.util.Collection actions = null;

		actions = new java.util.ArrayList(1);
		if(evaluateActions(actions, mySession)) {
			return true;
		}
		actions = null;

		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition1", "menPrincipal:noinputcount", com.avaya.sce.runtime.Expression.INT_GREATER_THEN_EQUAL, "1", false).setDebugId(5197)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("datValidaIntentosMenuPrincipal", "NoInput").setDebugId(5198));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition2", "menPrincipal:nomatchcount", com.avaya.sce.runtime.Expression.INT_GREATER_THEN_EQUAL, "1", false).setDebugId(5199)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("datValidaIntentosMenuPrincipal", "NoMatch").setDebugId(5200));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition3", "menPrincipal:value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "1", false).setDebugId(5201)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("vdnDesborde", "varConfiguracion:vdnDesactivacionSeguro", false).setDebugId(5761));
			actions.add(new com.avaya.sce.runtime.Next("datTransferencia", "1").setDebugId(5202));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition4", "menPrincipal:value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "2", false).setDebugId(5203)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("vdnDesborde", "varConfiguracion:vdnInformacionSeguro", false).setDebugId(5762));
			actions.add(new com.avaya.sce.runtime.Next("datTransferencia", "2").setDebugId(5204));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition5", "menPrincipal:value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "3", false).setDebugId(5205)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("vdnDesborde", "varConfiguracion:vdnQuejaReclamo", false).setDebugId(5763));
			actions.add(new com.avaya.sce.runtime.Next("datTransferencia", "3").setDebugId(5206));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition6", "menPrincipal:value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "4", false).setDebugId(5207)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("menEstadoSiniestro", "4").setDebugId(5208));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition7", "menPrincipal:value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "5", false).setDebugId(5789)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("menInformacionEcosistema", "5").setDebugId(5792));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition8", "menPrincipal:value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "8", false).setDebugId(5790)).evaluate(mySession)) {
			actions = new java.util.ArrayList(2);
			actions.add(new com.avaya.sce.runtime.varoperations.Assign("vdnDesborde", "varConfiguracion:vdnActividadEconomica", false).setDebugId(5794));
			actions.add(new com.avaya.sce.runtime.Next("datTransferencia", "8").setDebugId(5791));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}


		if(((com.avaya.sce.runtime.Condition)new com.avaya.sce.runtime.Condition("condition9", "menPrincipal:value", com.avaya.sce.runtime.Expression.STRING_EQUAL, "9", false).setDebugId(5211)).evaluate(mySession)) {
			actions = new java.util.ArrayList(1);
			actions.add(new com.avaya.sce.runtime.Next("datRepetirMenuPrincipal", "9").setDebugId(5212));
			if(evaluateActions(actions, mySession)) {
				return true;
			}
			actions = null;

		}

		// return false if the evaluation of actions did not cause a servlet forward or redirect
		return false;
	}
	

}
