package org.openetcs.es3f.exporter;

import org.eclipse.emf.ecore.EObject;
import org.openetcs.es3f.generated.acceptor;
import org.openetcs.es3f.utils.ManualTranslation;
import org.openetcs.model.ertmsformalspecs.*;
import org.openetcs.model.ertmsformalspecs.behaviour.*;
import org.openetcs.model.ertmsformalspecs.customization.*;
import org.openetcs.model.ertmsformalspecs.requirements.*;
import org.openetcs.model.ertmsformalspecs.requirements.messages.*;
import org.openetcs.model.ertmsformalspecs.shortcut.*;
import org.openetcs.model.ertmsformalspecs.test.*;
import org.openetcs.model.ertmsformalspecs.translation.*;
import org.openetcs.model.ertmsformalspecs.types.*;
import org.openetcs.model.ertmsformalspecs.util.*;

public class Exporter
{
	public static org.openetcs.es3f.generated.Dictionary exportDictionary ( org.openetcs.model.ertmsformalspecs.Dictionary source )
	{
		org.openetcs.es3f.generated.Dictionary retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createDictionary();
			if ( source.getSpecification() != null )
			{
				retVal.setSpecification(exportSpecification(source.getSpecification()));	
			}
			if ( source.getRuleDisablings() != null )
			{
				for ( EObject eObject: source.getRuleDisablings())
				{
					if (CustomizationPackage.eINSTANCE.getRuleDisabling().equals(eObject.eClass()))
					{
						retVal.appendRuleDisablings(exportRuleDisabling((RuleDisabling)eObject));
					}	
				}
			}
			if ( source.getNamespaces() != null )
			{
				for ( EObject eObject: source.getNamespaces())
				{
					if (ModelPackage.eINSTANCE.getNamespace().equals(eObject.eClass()))
					{
						retVal.appendNameSpaces(exportNameSpace((Namespace)eObject));
					}	
				}
			}
			if ( source.getTests() != null )
			{
				for ( EObject eObject: source.getTests())
				{
					if (TestPackage.eINSTANCE.getFrame().equals(eObject.eClass()))
					{
						retVal.appendTests(exportFrame((Frame)eObject));
					}	
				}
			}
			if ( source.getTranslations() != null )
			{
				retVal.setTranslationDictionary(exportTranslationDictionary(source.getTranslations()));	
			}
			if ( source.getShortcuts() != null )
			{
				retVal.setShortcutDictionary(exportShortcutDictionary(source.getShortcuts()));	
			}

			// Handles the translation of Xsi
			// Handles the translation of XsiLocation
			ManualTranslation.exportDictionary ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.RuleDisabling exportRuleDisabling ( org.openetcs.model.ertmsformalspecs.customization.RuleDisabling source )
	{
		org.openetcs.es3f.generated.RuleDisabling retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createRuleDisabling();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());

			// Handles the translation of Rule
			ManualTranslation.exportRuleDisabling ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.NameSpace exportNameSpace ( org.openetcs.model.ertmsformalspecs.Namespace source )
	{
		org.openetcs.es3f.generated.NameSpace retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createNameSpace();
			retVal.setName(source.getName());
			if ( source.getSubNamespaces() != null )
			{
				for ( EObject eObject: source.getSubNamespaces())
				{
					if (ModelPackage.eINSTANCE.getNamespace().equals(eObject.eClass()))
					{
						retVal.appendNameSpaces(exportNameSpace((Namespace)eObject));
					}	
				}
			}
			if ( source.getTypes() != null )
			{
				for ( EObject eObject: source.getTypes())
				{
					if (TypesPackage.eINSTANCE.getRange().equals(eObject.eClass()))
					{
						retVal.appendRanges(exportRange((Range)eObject));
					}	
				}
			}
			if ( source.getTypes() != null )
			{
				for ( EObject eObject: source.getTypes())
				{
					if (TypesPackage.eINSTANCE.getEnumeration().equals(eObject.eClass()))
					{
						retVal.appendEnumerations(exportEnum((Enumeration)eObject));
					}	
				}
			}
			if ( source.getTypes() != null )
			{
				for ( EObject eObject: source.getTypes())
				{
					if (TypesPackage.eINSTANCE.getStructure().equals(eObject.eClass()))
					{
						retVal.appendStructures(exportStructure((Structure)eObject));
					}	
				}
			}
			if ( source.getTypes() != null )
			{
				for ( EObject eObject: source.getTypes())
				{
					if (TypesPackage.eINSTANCE.getCollection().equals(eObject.eClass()))
					{
						retVal.appendCollections(exportCollection((Collection)eObject));
					}	
				}
			}
			if ( source.getTypes() != null )
			{
				for ( EObject eObject: source.getTypes())
				{
					if (TypesPackage.eINSTANCE.getFunction().equals(eObject.eClass()))
					{
						retVal.appendFunctions(exportFunction((Function)eObject));
					}	
				}
			}
			if ( source.getProcedures() != null )
			{
				for ( EObject eObject: source.getProcedures())
				{
					if (ModelPackage.eINSTANCE.getProcedure().equals(eObject.eClass()))
					{
						retVal.appendProcedures(exportProcedure((Procedure)eObject));
					}	
				}
			}
			if ( source.getVariables() != null )
			{
				for ( EObject eObject: source.getVariables())
				{
					if (ModelPackage.eINSTANCE.getVariable().equals(eObject.eClass()))
					{
						retVal.appendVariables(exportVariable((Variable)eObject));
					}	
				}
			}
			if ( source.getRules() != null )
			{
				for ( EObject eObject: source.getRules())
				{
					if (BehaviourPackage.eINSTANCE.getRule().equals(eObject.eClass()))
					{
						retVal.appendRules(exportRule((Rule)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.ReqRef exportReqRef ( org.openetcs.model.ertmsformalspecs.ReqRef source )
	{
		org.openetcs.es3f.generated.ReqRef retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createReqRef();
			retVal.setComment(source.getComment());

			// Handles the translation of Id
			ManualTranslation.exportReqRef ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Enum exportEnum ( org.openetcs.model.ertmsformalspecs.types.Enumeration source )
	{
		org.openetcs.es3f.generated.Enum retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createEnum();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setDefault(source.getDefaultValue());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getValues() != null )
			{
				for ( EObject eObject: source.getValues())
				{
					if (TypesPackage.eINSTANCE.getEnumValue().equals(eObject.eClass()))
					{
						retVal.appendValues(exportEnumValue((EnumValue)eObject));
					}	
				}
			}
			if ( source.getSubEnumerations() != null )
			{
				for ( EObject eObject: source.getSubEnumerations())
				{
					if (TypesPackage.eINSTANCE.getEnumeration().equals(eObject.eClass()))
					{
						retVal.appendSubEnums(exportEnum((Enumeration)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.EnumValue exportEnumValue ( org.openetcs.model.ertmsformalspecs.types.EnumValue source )
	{
		org.openetcs.es3f.generated.EnumValue retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createEnumValue();
			retVal.setName(source.getName());
			retVal.setValue(source.getValue());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Range exportRange ( org.openetcs.model.ertmsformalspecs.types.Range source )
	{
		org.openetcs.es3f.generated.Range retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createRange();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setDefault(source.getDefaultValue());
			retVal.setMinValue(source.getMinimumValue());
			retVal.setMaxValue(source.getMaximumValue());
			retVal.setPrecision_AsString(source.getPrecision().getName());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getSpecialValues() != null )
			{
				for ( EObject eObject: source.getSpecialValues())
				{
					if (TypesPackage.eINSTANCE.getEnumValue().equals(eObject.eClass()))
					{
						retVal.appendSpecialValues(exportEnumValue((EnumValue)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Structure exportStructure ( org.openetcs.model.ertmsformalspecs.types.Structure source )
	{
		org.openetcs.es3f.generated.Structure retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createStructure();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setDefault(source.getDefaultValue());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getRules() != null )
			{
				for ( EObject eObject: source.getRules())
				{
					if (BehaviourPackage.eINSTANCE.getRule().equals(eObject.eClass()))
					{
						retVal.appendRules(exportRule((Rule)eObject));
					}	
				}
			}
			if ( source.getProcedures() != null )
			{
				for ( EObject eObject: source.getProcedures())
				{
					if (ModelPackage.eINSTANCE.getProcedure().equals(eObject.eClass()))
					{
						retVal.appendProcedures(exportStructureProcedure((Procedure)eObject));
					}	
				}
			}
			if ( source.getElements() != null )
			{
				for ( EObject eObject: source.getElements())
				{
					if (TypesPackage.eINSTANCE.getStructureElement().equals(eObject.eClass()))
					{
						retVal.appendElements(exportStructureElement((StructureElement)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.StructureElement exportStructureElement ( org.openetcs.model.ertmsformalspecs.types.StructureElement source )
	{
		org.openetcs.es3f.generated.StructureElement retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createStructureElement();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setTypeName(source.getTypeName());
			retVal.setDefault(source.getDefaultValue());
			retVal.setMode_AsString(source.getVariableMode().getName());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.StructureProcedure exportStructureProcedure ( org.openetcs.model.ertmsformalspecs.Procedure source )
	{
		org.openetcs.es3f.generated.StructureProcedure retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createStructureProcedure();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getParameters() != null )
			{
				for ( EObject eObject: source.getParameters())
				{
					if (ModelPackage.eINSTANCE.getParameter().equals(eObject.eClass()))
					{
						retVal.appendParameters(exportParameter((Parameter)eObject));
					}	
				}
			}
			if ( source.getRules() != null )
			{
				for ( EObject eObject: source.getRules())
				{
					if (BehaviourPackage.eINSTANCE.getRule().equals(eObject.eClass()))
					{
						retVal.appendRules(exportRule((Rule)eObject));
					}	
				}
			}
			if ( source.getStateMachine() != null )
			{
				retVal.setStateMachine(exportStateMachine(source.getStateMachine()));	
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Collection exportCollection ( org.openetcs.model.ertmsformalspecs.types.Collection source )
	{
		org.openetcs.es3f.generated.Collection retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createCollection();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setDefault(source.getDefaultValue());
			retVal.setTypeName(source.getTypeName());
			retVal.setMaxSize(source.getMaximumSize());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Function exportFunction ( org.openetcs.model.ertmsformalspecs.types.Function source )
	{
		org.openetcs.es3f.generated.Function retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createFunction();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setDefault(source.getDefaultValue());
			retVal.setTypeName(source.getTypeName());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getParameters() != null )
			{
				for ( EObject eObject: source.getParameters())
				{
					if (ModelPackage.eINSTANCE.getParameter().equals(eObject.eClass()))
					{
						retVal.appendParameters(exportParameter((Parameter)eObject));
					}	
				}
			}
			if ( source.getCases() != null )
			{
				for ( EObject eObject: source.getCases())
				{
					if (TypesPackage.eINSTANCE.getCase().equals(eObject.eClass()))
					{
						retVal.appendCases(exportCase((Case)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Parameter exportParameter ( org.openetcs.model.ertmsformalspecs.Parameter source )
	{
		org.openetcs.es3f.generated.Parameter retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createParameter();
			retVal.setName(source.getName());
			retVal.setTypeName(source.getTypeName());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Case exportCase ( org.openetcs.model.ertmsformalspecs.types.Case source )
	{
		org.openetcs.es3f.generated.Case retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createCase();
			retVal.setName(source.getName());
			if ( source.getPreConditions() != null )
			{
				for ( EObject eObject: source.getPreConditions())
				{
					if (BehaviourPackage.eINSTANCE.getPreCondition().equals(eObject.eClass()))
					{
						retVal.appendPreConditions(exportPreCondition((PreCondition)eObject));
					}	
				}
			}
			retVal.setExpression(source.getExpression());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Procedure exportProcedure ( org.openetcs.model.ertmsformalspecs.Procedure source )
	{
		org.openetcs.es3f.generated.Procedure retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createProcedure();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getParameters() != null )
			{
				for ( EObject eObject: source.getParameters())
				{
					if (ModelPackage.eINSTANCE.getParameter().equals(eObject.eClass()))
					{
						retVal.appendParameters(exportParameter((Parameter)eObject));
					}	
				}
			}
			if ( source.getRules() != null )
			{
				for ( EObject eObject: source.getRules())
				{
					if (BehaviourPackage.eINSTANCE.getRule().equals(eObject.eClass()))
					{
						retVal.appendRules(exportRule((Rule)eObject));
					}	
				}
			}
			if ( source.getStateMachine() != null )
			{
				retVal.setStateMachine(exportStateMachine(source.getStateMachine()));	
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.StateMachine exportStateMachine ( org.openetcs.model.ertmsformalspecs.StateMachine source )
	{
		org.openetcs.es3f.generated.StateMachine retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createStateMachine();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setDefault(source.getDefaultValue());
			retVal.setInitialState(source.getInitialState());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getStates() != null )
			{
				for ( EObject eObject: source.getStates())
				{
					if (ModelPackage.eINSTANCE.getState().equals(eObject.eClass()))
					{
						retVal.appendStates(exportState((State)eObject));
					}	
				}
			}
			if ( source.getRules() != null )
			{
				for ( EObject eObject: source.getRules())
				{
					if (BehaviourPackage.eINSTANCE.getRule().equals(eObject.eClass()))
					{
						retVal.appendRules(exportRule((Rule)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.State exportState ( org.openetcs.model.ertmsformalspecs.State source )
	{
		org.openetcs.es3f.generated.State retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createState();
			retVal.setName(source.getName());
			retVal.setX(source.getX());
			retVal.setY(source.getY());
			retVal.setWidth(source.getWidth());
			retVal.setHeight(source.getHeight());
			if ( source.getStateMachine() != null )
			{
				retVal.setStateMachine(exportStateMachine(source.getStateMachine()));	
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Variable exportVariable ( org.openetcs.model.ertmsformalspecs.Variable source )
	{
		org.openetcs.es3f.generated.Variable retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createVariable();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setTypeName(source.getTypeName());
			retVal.setDefaultValue(source.getDefaultValue());
			retVal.setVariableMode_AsString(source.getVariableMode().getName());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getSubVariables() != null )
			{
				for ( EObject eObject: source.getSubVariables())
				{
					if (ModelPackage.eINSTANCE.getVariable().equals(eObject.eClass()))
					{
						retVal.appendSubVariables(exportVariable((Variable)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Rule exportRule ( org.openetcs.model.ertmsformalspecs.behaviour.Rule source )
	{
		org.openetcs.es3f.generated.Rule retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createRule();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setPriority_AsString(source.getPriority().getName());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getConditions() != null )
			{
				for ( EObject eObject: source.getConditions())
				{
					if (BehaviourPackage.eINSTANCE.getRuleCondition().equals(eObject.eClass()))
					{
						retVal.appendConditions(exportRuleCondition((RuleCondition)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.RuleCondition exportRuleCondition ( org.openetcs.model.ertmsformalspecs.behaviour.RuleCondition source )
	{
		org.openetcs.es3f.generated.RuleCondition retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createRuleCondition();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getPreconditions() != null )
			{
				for ( EObject eObject: source.getPreconditions())
				{
					if (BehaviourPackage.eINSTANCE.getPreCondition().equals(eObject.eClass()))
					{
						retVal.appendPreConditions(exportPreCondition((PreCondition)eObject));
					}	
				}
			}
			if ( source.getActions() != null )
			{
				for ( EObject eObject: source.getActions())
				{
					if (BehaviourPackage.eINSTANCE.getAction().equals(eObject.eClass()))
					{
						retVal.appendActions(exportAction((Action)eObject));
					}	
				}
			}
			if ( source.getSubRules() != null )
			{
				for ( EObject eObject: source.getSubRules())
				{
					if (BehaviourPackage.eINSTANCE.getRule().equals(eObject.eClass()))
					{
						retVal.appendSubRules(exportRule((Rule)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.PreCondition exportPreCondition ( org.openetcs.model.ertmsformalspecs.behaviour.PreCondition source )
	{
		org.openetcs.es3f.generated.PreCondition retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createPreCondition();
			retVal.setCondition(source.getCondition());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Action exportAction ( org.openetcs.model.ertmsformalspecs.behaviour.Action source )
	{
		org.openetcs.es3f.generated.Action retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createAction();
			retVal.setExpression(source.getExpression());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Frame exportFrame ( org.openetcs.model.ertmsformalspecs.test.Frame source )
	{
		org.openetcs.es3f.generated.Frame retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createFrame();
			retVal.setName(source.getName());
			if ( source.getSubSequences() != null )
			{
				for ( EObject eObject: source.getSubSequences())
				{
					if (TestPackage.eINSTANCE.getSubSequence().equals(eObject.eClass()))
					{
						retVal.appendSubSequences(exportSubSequence((SubSequence)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.SubSequence exportSubSequence ( org.openetcs.model.ertmsformalspecs.test.SubSequence source )
	{
		org.openetcs.es3f.generated.SubSequence retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createSubSequence();
			retVal.setName(source.getName());
			retVal.setD_LRBG(source.getDLRBG());
			retVal.setLevel(source.getLevel());
			retVal.setMode(source.getMode());
			retVal.setNID_LRBG(source.getNidLRBG());
			retVal.setQ_DIRLRBG(source.getQDirLRBG());
			retVal.setQ_DIRTRAIN(source.getQDirTrain());
			retVal.setQ_DLRBG(source.getQDLRBG());
			retVal.setRBC_ID(source.getRbcId());
			retVal.setRBCPhone(source.getRbcPhone());
			if ( source.getTestCases() != null )
			{
				for ( EObject eObject: source.getTestCases())
				{
					if (TestPackage.eINSTANCE.getSingleTestCase().equals(eObject.eClass()))
					{
						retVal.appendTestCases(exportTestCase((SingleTestCase)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.TestCase exportTestCase ( org.openetcs.model.ertmsformalspecs.test.SingleTestCase source )
	{
		org.openetcs.es3f.generated.TestCase retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createTestCase();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			retVal.setVerified(source.isVerified());
			retVal.setNeedsRequirement(source.isNeedsRequirement());
			retVal.setFeature(source.getFeature());
			retVal.setCase(source.getCase());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getSteps() != null )
			{
				for ( EObject eObject: source.getSteps())
				{
					if (TestPackage.eINSTANCE.getStep().equals(eObject.eClass()))
					{
						retVal.appendSteps(exportStep((Step)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Step exportStep ( org.openetcs.model.ertmsformalspecs.test.Step source )
	{
		org.openetcs.es3f.generated.Step retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createStep();
			retVal.setName(source.getName());
			retVal.setTCS_Order(source.getTcsOrder());
			retVal.setDistance(source.getDistance());
			retVal.setIO_AsString(source.getIo().getName());
			retVal.setLevelIN_AsString(source.getLevelIn().getName());
			retVal.setLevelOUT_AsString(source.getLevelOut().getName());
			retVal.setModeIN_AsString(source.getModeIn().getName());
			retVal.setModeOUT_AsString(source.getModeOut().getName());
			retVal.setTranslationRequired(source.isTranslationRequired());
			retVal.setTranslated(source.isTranslated());
			if ( source.getSubSteps() != null )
			{
				for ( EObject eObject: source.getSubSteps())
				{
					if (TestPackage.eINSTANCE.getSubStep().equals(eObject.eClass()))
					{
						retVal.appendSubSteps(exportSubStep((SubStep)eObject));
					}	
				}
			}
			if ( source.getMessages() != null )
			{
				for ( EObject eObject: source.getMessages())
				{
					if (TestPackage.eINSTANCE.getTestMessage().equals(eObject.eClass()))
					{
						retVal.appendMessages(exportDBMessage((TestMessage)eObject));
					}	
				}
			}
			retVal.setDescription(source.getDescription());
			retVal.setComment(source.getComment());
			retVal.setUserComment(source.getUserComment());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.SubStep exportSubStep ( org.openetcs.model.ertmsformalspecs.test.SubStep source )
	{
		org.openetcs.es3f.generated.SubStep retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createSubStep();
			retVal.setName(source.getName());
			retVal.setSkipEngine(source.isSkipEngine());
			if ( source.getActions() != null )
			{
				for ( EObject eObject: source.getActions())
				{
					if (BehaviourPackage.eINSTANCE.getAction().equals(eObject.eClass()))
					{
						retVal.appendActions(exportAction((Action)eObject));
					}	
				}
			}
			if ( source.getExpectations() != null )
			{
				for ( EObject eObject: source.getExpectations())
				{
					if (TestPackage.eINSTANCE.getExpectation().equals(eObject.eClass()))
					{
						retVal.appendExpectations(exportExpectation((Expectation)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Expectation exportExpectation ( org.openetcs.model.ertmsformalspecs.test.Expectation source )
	{
		org.openetcs.es3f.generated.Expectation retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createExpectation();
			retVal.setName(source.getName());
			retVal.setVariable(source.getVariable());
			retVal.setBlocking(source.isBlocking());
			retVal.setDeadLine(source.getDeadline());
			retVal.setValue(source.getValue());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.DBMessage exportDBMessage ( org.openetcs.model.ertmsformalspecs.test.TestMessage source )
	{
		org.openetcs.es3f.generated.DBMessage retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createDBMessage();
			retVal.setName(source.getName());
			retVal.setMessageOrder(source.getOrder());
			if ( source.getFields() != null )
			{
				for ( EObject eObject: source.getFields())
				{
					if (TestPackage.eINSTANCE.getTestField().equals(eObject.eClass()))
					{
						retVal.appendFields(exportDBField((TestField)eObject));
					}	
				}
			}
			if ( source.getPackets() != null )
			{
				for ( EObject eObject: source.getPackets())
				{
					if (TestPackage.eINSTANCE.getTestPacket().equals(eObject.eClass()))
					{
						retVal.appendPackets(exportDBPacket((TestPacket)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.DBPacket exportDBPacket ( org.openetcs.model.ertmsformalspecs.test.TestPacket source )
	{
		org.openetcs.es3f.generated.DBPacket retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createDBPacket();
			retVal.setName(source.getName());
			if ( source.getFields() != null )
			{
				for ( EObject eObject: source.getFields())
				{
					if (TestPackage.eINSTANCE.getTestField().equals(eObject.eClass()))
					{
						retVal.appendFields(exportDBField((TestField)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.DBField exportDBField ( org.openetcs.model.ertmsformalspecs.test.TestField source )
	{
		org.openetcs.es3f.generated.DBField retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createDBField();
			retVal.setName(source.getName());
			retVal.setValue(source.getValue());
			retVal.setVariable(source.getVariable());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.TranslationDictionary exportTranslationDictionary ( org.openetcs.model.ertmsformalspecs.translation.TranslationFolder source )
	{
		org.openetcs.es3f.generated.TranslationDictionary retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createTranslationDictionary();
			retVal.setName(source.getName());
			if ( source.getSubFolders() != null )
			{
				for ( EObject eObject: source.getSubFolders())
				{
					if (TranslationPackage.eINSTANCE.getTranslationFolder().equals(eObject.eClass()))
					{
						retVal.appendFolders(exportFolder((TranslationFolder)eObject));
					}	
				}
			}
			if ( source.getTranslations() != null )
			{
				for ( EObject eObject: source.getTranslations())
				{
					if (TranslationPackage.eINSTANCE.getTranslation().equals(eObject.eClass()))
					{
						retVal.appendTranslations(exportTranslation((Translation)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Folder exportFolder ( org.openetcs.model.ertmsformalspecs.translation.TranslationFolder source )
	{
		org.openetcs.es3f.generated.Folder retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createFolder();
			retVal.setName(source.getName());
			if ( source.getSubFolders() != null )
			{
				for ( EObject eObject: source.getSubFolders())
				{
					if (TranslationPackage.eINSTANCE.getTranslationFolder().equals(eObject.eClass()))
					{
						retVal.appendFolders(exportFolder((TranslationFolder)eObject));
					}	
				}
			}
			if ( source.getTranslations() != null )
			{
				for ( EObject eObject: source.getTranslations())
				{
					if (TranslationPackage.eINSTANCE.getTranslation().equals(eObject.eClass()))
					{
						retVal.appendTranslations(exportTranslation((Translation)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Translation exportTranslation ( org.openetcs.model.ertmsformalspecs.translation.Translation source )
	{
		org.openetcs.es3f.generated.Translation retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createTranslation();
			retVal.setName(source.getName());
			retVal.setImplemented(source.isImplemented());
			if ( source.getSources() != null )
			{
				for ( EObject eObject: source.getSources())
				{
					if (TranslationPackage.eINSTANCE.getSourceText().equals(eObject.eClass()))
					{
						retVal.appendSourceTexts(exportSourceText((SourceText)eObject));
					}	
				}
			}
			if ( source.getSubSteps() != null )
			{
				for ( EObject eObject: source.getSubSteps())
				{
					if (TestPackage.eINSTANCE.getSubStep().equals(eObject.eClass()))
					{
						retVal.appendSubSteps(exportSubStep((SubStep)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.SourceText exportSourceText ( org.openetcs.model.ertmsformalspecs.translation.SourceText source )
	{
		org.openetcs.es3f.generated.SourceText retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createSourceText();
			retVal.setName(source.getName());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.ShortcutDictionary exportShortcutDictionary ( org.openetcs.model.ertmsformalspecs.shortcut.ShortcutFolder source )
	{
		org.openetcs.es3f.generated.ShortcutDictionary retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createShortcutDictionary();
			retVal.setName(source.getName());
			if ( source.getSubFolders() != null )
			{
				for ( EObject eObject: source.getSubFolders())
				{
					if (ShortcutPackage.eINSTANCE.getShortcutFolder().equals(eObject.eClass()))
					{
						retVal.appendFolders(exportShortcutFolder((ShortcutFolder)eObject));
					}	
				}
			}
			if ( source.getShortcuts() != null )
			{
				for ( EObject eObject: source.getShortcuts())
				{
					if (ShortcutPackage.eINSTANCE.getShortcut().equals(eObject.eClass()))
					{
						retVal.appendShortcuts(exportShortcut((Shortcut)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.ShortcutFolder exportShortcutFolder ( org.openetcs.model.ertmsformalspecs.shortcut.ShortcutFolder source )
	{
		org.openetcs.es3f.generated.ShortcutFolder retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createShortcutFolder();
			retVal.setName(source.getName());
			if ( source.getSubFolders() != null )
			{
				for ( EObject eObject: source.getSubFolders())
				{
					if (ShortcutPackage.eINSTANCE.getShortcutFolder().equals(eObject.eClass()))
					{
						retVal.appendFolders(exportShortcutFolder((ShortcutFolder)eObject));
					}	
				}
			}
			if ( source.getShortcuts() != null )
			{
				for ( EObject eObject: source.getShortcuts())
				{
					if (ShortcutPackage.eINSTANCE.getShortcut().equals(eObject.eClass()))
					{
						retVal.appendShortcuts(exportShortcut((Shortcut)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Shortcut exportShortcut ( org.openetcs.model.ertmsformalspecs.shortcut.Shortcut source )
	{
		org.openetcs.es3f.generated.Shortcut retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createShortcut();
			retVal.setName(source.getName());

			// Handles the translation of ShortcutName
			ManualTranslation.exportShortcut ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Specification exportSpecification ( org.openetcs.model.ertmsformalspecs.requirements.Specification source )
	{
		org.openetcs.es3f.generated.Specification retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createSpecification();
			retVal.setName(source.getName());
			if ( source.getParagraphs() != null )
			{
				for ( EObject eObject: source.getParagraphs())
				{
					if (RequirementsPackage.eINSTANCE.getParagraph().equals(eObject.eClass()))
					{
						retVal.appendChapters(exportChapter((Paragraph)eObject));
					}	
				}
			}

			// Handles the translation of Version
			ManualTranslation.exportSpecification ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Chapter exportChapter ( org.openetcs.model.ertmsformalspecs.requirements.Paragraph source )
	{
		org.openetcs.es3f.generated.Chapter retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createChapter();
			retVal.setName(source.getName());
			retVal.setId(source.getId());
			if ( source.getSubParagraphs() != null )
			{
				for ( EObject eObject: source.getSubParagraphs())
				{
					if (RequirementsPackage.eINSTANCE.getParagraph().equals(eObject.eClass()))
					{
						retVal.appendParagraphs(exportParagraph((Paragraph)eObject));
					}	
				}
			}
			if ( source.getTypeSpecs() != null )
			{
				for ( EObject eObject: source.getTypeSpecs())
				{
					if (MessagesPackage.eINSTANCE.getTypeSpec().equals(eObject.eClass()))
					{
						retVal.appendTypeSpecs(exportTypeSpec((TypeSpec)eObject));
					}	
				}
			}
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Paragraph exportParagraph ( org.openetcs.model.ertmsformalspecs.requirements.Paragraph source )
	{
		org.openetcs.es3f.generated.Paragraph retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createParagraph();
			retVal.setName(source.getName());
			retVal.setId(source.getId());
			retVal.setType_AsString(source.getType().getName());
			retVal.setName(source.getName());
			if ( source.getRequirements() != null )
			{
				for ( EObject eObject: source.getRequirements())
				{
					if (ModelPackage.eINSTANCE.getReqRef().equals(eObject.eClass()))
					{
						retVal.appendRequirements(exportReqRef((ReqRef)eObject));
					}	
				}
			}
			retVal.setComment(source.getComment());
			if ( source.getMessage() != null )
			{
				retVal.setMessage(exportMessage(source.getMessage()));	
			}
			if ( source.getSubParagraphs() != null )
			{
				for ( EObject eObject: source.getSubParagraphs())
				{
					if (RequirementsPackage.eINSTANCE.getParagraph().equals(eObject.eClass()))
					{
						retVal.appendParagraphs(exportParagraph((Paragraph)eObject));
					}	
				}
			}
			if ( source.getTypeSpecs() != null )
			{
				for ( EObject eObject: source.getTypeSpecs())
				{
					if (MessagesPackage.eINSTANCE.getTypeSpec().equals(eObject.eClass()))
					{
						retVal.appendTypeSpecs(exportTypeSpec((TypeSpec)eObject));
					}	
				}
			}
			retVal.setText(source.getText());

			// Handles the translation of Scope
			// Handles the translation of Bl
			// Handles the translation of Optional
			// Handles the translation of Version
			// Handles the translation of Reviewed
			// Handles the translation of ImplementationStatus
			// Handles the translation of Revision
			// Handles the translation of MoreInfoRequired
			// Handles the translation of SpecIssue
			// Handles the translation of FunctionalBlock
			// Handles the translation of FunctionalBlockName
			ManualTranslation.exportParagraph ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.Message exportMessage ( org.openetcs.model.ertmsformalspecs.requirements.messages.Message source )
	{
		org.openetcs.es3f.generated.Message retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createMessage();
			retVal.setDescription(source.getDescription());
			if ( source.getVariables() != null )
			{
				for ( EObject eObject: source.getVariables())
				{
					if (MessagesPackage.eINSTANCE.getMessageVariable().equals(eObject.eClass()))
					{
						retVal.appendMsgVariables(exportMsgVariable((MessageVariable)eObject));
					}	
				}
			}

			// Handles the translation of Media
			// Handles the translation of Bl
			ManualTranslation.exportMessage ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.MsgVariable exportMsgVariable ( org.openetcs.model.ertmsformalspecs.requirements.messages.MessageVariable source )
	{
		org.openetcs.es3f.generated.MsgVariable retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createMsgVariable();
			retVal.setName(source.getName());
			retVal.setLength(source.getLength());
			retVal.setComment(source.getComment());
			if ( source.getSubVariables() != null )
			{
				for ( EObject eObject: source.getSubVariables())
				{
					if (MessagesPackage.eINSTANCE.getMessageVariable().equals(eObject.eClass()))
					{
						retVal.appendMsgVariables(exportMsgVariable((MessageVariable)eObject));
					}	
				}
			}

			// Handles the translation of Bl
			ManualTranslation.exportMsgVariable ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.TypeSpec exportTypeSpec ( org.openetcs.model.ertmsformalspecs.requirements.messages.TypeSpec source )
	{
		org.openetcs.es3f.generated.TypeSpec retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createTypeSpec();
			retVal.setLength(source.getLength());
			retVal.setMinimum_value(source.getMinimumValue());
			retVal.setMaximum_value(source.getMaximumValue());
			retVal.setResolution_formula(source.getResolutionFormula());
			retVal.setId(source.getId());
			retVal.setDescription(source.getDescription());

			// Handles the translation of Bl
			// Handles the translation of Values
			ManualTranslation.exportTypeSpec ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.special_or_reserved_value exportspecial_or_reserved_value ( org.openetcs.model.ertmsformalspecs.requirements.messages.SpecialOrReservedValue source )
	{
		org.openetcs.es3f.generated.special_or_reserved_value retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createspecial_or_reserved_value();
			if ( source.getMask() != null )
			{
				retVal.setMask(exportmask(source.getMask()));	
			}
			if ( source.getMeaning() != null )
			{
				retVal.setMeaning(exportmeaning(source.getMeaning()));	
			}
			if ( source.getValue() != null )
			{
				retVal.setValue(exportvalue(source.getValue()));	
			}

			// Handles the translation of Match
			// Handles the translation of Match-range
			ManualTranslation.exportspecial_or_reserved_value ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.mask exportmask ( org.openetcs.model.ertmsformalspecs.requirements.messages.Mask source )
	{
		org.openetcs.es3f.generated.mask retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createmask();
			retVal.setValue(source.getValue());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.match exportmatch ( org.openetcs.model.ertmsformalspecs.requirements.messages.Match source )
	{
		org.openetcs.es3f.generated.match retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().creatematch();
			retVal.setValue(source.getValue());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.meaning exportmeaning ( org.openetcs.model.ertmsformalspecs.requirements.messages.Meaning source )
	{
		org.openetcs.es3f.generated.meaning retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createmeaning();
			retVal.setType_AsString(source.getType().getName());
			retVal.setValue(source.getValue());

			// Handles the translation of Bl
			ManualTranslation.exportmeaning ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.match_range exportmatch_range ( org.openetcs.model.ertmsformalspecs.requirements.messages.MatchRange source )
	{
		org.openetcs.es3f.generated.match_range retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().creatematch_range();
			retVal.setMinimum(source.getMinimum());

			// Handles the translation of Maximum
			ManualTranslation.exportmatch_range ( source, retVal );
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.resolution_formula exportresolution_formula ( org.openetcs.model.ertmsformalspecs.requirements.messages.ResolutionFormula source )
	{
		org.openetcs.es3f.generated.resolution_formula retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createresolution_formula();
			retVal.setUnits_AsString(source.getUnit().getName());
			retVal.setValue_AsString(source.getValue().getName());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.value exportvalue ( org.openetcs.model.ertmsformalspecs.requirements.messages.SingleValue source )
	{
		org.openetcs.es3f.generated.value retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createvalue();
			retVal.setUnits(source.getUnits());
			retVal.setValue(source.getValue());
		}
		
		return retVal;
	}      

	public static org.openetcs.es3f.generated.char_value exportchar_value ( org.openetcs.model.ertmsformalspecs.requirements.messages.CharValue source )
	{
		org.openetcs.es3f.generated.char_value retVal = null; 
		
		if ( source != null )
		{
			retVal = acceptor.getFactory().createchar_value();
			retVal.setEncoding(source.getEncoding());
		}
		
		return retVal;
	}      

}
