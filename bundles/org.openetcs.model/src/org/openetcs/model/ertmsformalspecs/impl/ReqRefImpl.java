/**
 */
package org.openetcs.model.ertmsformalspecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.openetcs.model.ertmsformalspecs.ModelPackage;
import org.openetcs.model.ertmsformalspecs.ReqRef;
import org.openetcs.model.ertmsformalspecs.requirements.Paragraph;
import org.openetcs.model.ertmsformalspecs.requirements.RequirementsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Req Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.openetcs.model.ertmsformalspecs.impl.ReqRefImpl#getParagraph <em>Paragraph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ReqRefImpl extends CommentedElementImpl implements ReqRef {
	/**
	 * The cached value of the '{@link #getParagraph() <em>Paragraph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParagraph()
	 * @generated
	 * @ordered
	 */
	protected Paragraph paragraph;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReqRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.REQ_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Paragraph getParagraph() {
		if (paragraph != null && paragraph.eIsProxy()) {
			InternalEObject oldParagraph = (InternalEObject)paragraph;
			paragraph = (Paragraph)eResolveProxy(oldParagraph);
			if (paragraph != oldParagraph) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.REQ_REF__PARAGRAPH, oldParagraph, paragraph));
			}
		}
		return paragraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Paragraph basicGetParagraph() {
		return paragraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParagraph(Paragraph newParagraph, NotificationChain msgs) {
		Paragraph oldParagraph = paragraph;
		paragraph = newParagraph;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.REQ_REF__PARAGRAPH, oldParagraph, newParagraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParagraph(Paragraph newParagraph) {
		if (newParagraph != paragraph) {
			NotificationChain msgs = null;
			if (paragraph != null)
				msgs = ((InternalEObject)paragraph).eInverseRemove(this, RequirementsPackage.PARAGRAPH__IMPLEMENTATIONS, Paragraph.class, msgs);
			if (newParagraph != null)
				msgs = ((InternalEObject)newParagraph).eInverseAdd(this, RequirementsPackage.PARAGRAPH__IMPLEMENTATIONS, Paragraph.class, msgs);
			msgs = basicSetParagraph(newParagraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.REQ_REF__PARAGRAPH, newParagraph, newParagraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.REQ_REF__PARAGRAPH:
				if (paragraph != null)
					msgs = ((InternalEObject)paragraph).eInverseRemove(this, RequirementsPackage.PARAGRAPH__IMPLEMENTATIONS, Paragraph.class, msgs);
				return basicSetParagraph((Paragraph)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.REQ_REF__PARAGRAPH:
				return basicSetParagraph(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.REQ_REF__PARAGRAPH:
				if (resolve) return getParagraph();
				return basicGetParagraph();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.REQ_REF__PARAGRAPH:
				setParagraph((Paragraph)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.REQ_REF__PARAGRAPH:
				setParagraph((Paragraph)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.REQ_REF__PARAGRAPH:
				return paragraph != null;
		}
		return super.eIsSet(featureID);
	}

} //ReqRefImpl
