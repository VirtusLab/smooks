package org.milyn.ect.ecore;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;

/**
 * Interface to access Smooks-related EMF Annotations
 * 
 * @author zubairov
 * 
 */
public interface SmooksMetadata {

	public static final String ANNOTATION_TYPE = "smooks-mapping-data";
	public static final String SEGMENT_TYPE = "segment";
	public static final String SEGMENT_GROUP_TYPE = "group";
	public static final String FIELD_TYPE = "field";
	public static final String COMPONENT_TYPE = "component";
	public static final String ANNOTATION_TYPE_KEY = "type";
	public static final String SEGCODE = "segcode";

	public EAnnotation getSmooksAnnotation(EModelElement element);

	public boolean isSegment(EModelElement element);

	public String getSegcode(EModelElement element);

	public boolean isSegmentGroup(EModelElement element);

	public boolean isField(EModelElement element);

	public boolean isComponent(EModelElement feature);

	/**
	 * SINGLETON instance
	 * 
	 */
	public static final SmooksMetadata INSTANCE = new SmooksMetadata() {

		/**
		 * {@inheritDoc}
		 */
		public boolean isSegment(EModelElement element) {
			EAnnotation annotation = getSmooksAnnotation(element);
			if (annotation == null) {
				return false;
			}
			return SEGMENT_TYPE.equals(annotation.getDetails().get(
					ANNOTATION_TYPE_KEY));
		}

		/**
		 * {@inheritDoc}
		 */
		public EAnnotation getSmooksAnnotation(EModelElement element)
				throws IllegalArgumentException {
			EAnnotation annotation = element.getEAnnotation(ANNOTATION_TYPE);
			return annotation;
		}

		/**
		 * {@inheritDoc}
		 */
		public String getSegcode(EModelElement element)
				throws IllegalArgumentException {
			EAnnotation annotation = getSmooksAnnotation(element);
			if (annotation == null) {
				return null;
			}
			return annotation.getDetails().get(SEGCODE);
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isSegmentGroup(EModelElement element) {
			EAnnotation annotation = getSmooksAnnotation(element);
			if (annotation == null) {
				return false;
			}
			return SEGMENT_GROUP_TYPE.equals(annotation.getDetails().get(
					ANNOTATION_TYPE_KEY));
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isField(EModelElement element)
				throws IllegalArgumentException {
			EAnnotation annotation = element.getEAnnotation(ANNOTATION_TYPE);
			if (annotation == null) {
				return false;
			}
			return FIELD_TYPE.equals(annotation.getDetails().get(
					ANNOTATION_TYPE_KEY));
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean isComponent(EModelElement element) {
			EAnnotation annotation = element.getEAnnotation(ANNOTATION_TYPE);
			if (annotation == null) {
				return false;
			}
			return COMPONENT_TYPE.equals(annotation.getDetails().get(
					ANNOTATION_TYPE_KEY));
		}

	};

}
