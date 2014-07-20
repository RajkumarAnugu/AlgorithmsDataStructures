package dataStructures;

/**
 * 
 * 20. jul. 2014
 * 
 * @author GuoJunjun
 *         define an interface type to make visitation more generic.
 */
public interface Visitor {
	void init();

	void visit(Object data);
}
