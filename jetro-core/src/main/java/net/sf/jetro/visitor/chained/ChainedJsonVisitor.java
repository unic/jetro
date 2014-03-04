package net.sf.jetro.visitor.chained;

import net.sf.jetro.visitor.JsonArrayVisitor;
import net.sf.jetro.visitor.JsonObjectVisitor;
import net.sf.jetro.visitor.JsonVisitor;

public abstract class ChainedJsonVisitor<R> implements JsonVisitor<R> {
	private JsonVisitor<R> nextVisitor;

	/**
	 * This constructor is used if the resulting object is supposed to be the end point of a
	 * visitor chain. Without overwriting any hook methods this results in a no-op visitor.
	 */
	public ChainedJsonVisitor() {
	}

	public ChainedJsonVisitor(final JsonVisitor<R> nextVisitor) {
		this.nextVisitor = nextVisitor;
	}

	@Override
	public final JsonObjectVisitor<R> visitObject() {
		beforeVisitObject();
		return afterVisitObject(nextVisitor == null ? null : nextVisitor.visitObject());
	}

	protected void beforeVisitObject() {
	}

	protected JsonObjectVisitor<R> afterVisitObject(JsonObjectVisitor<R> jsonObjectVisitor) {
		return jsonObjectVisitor;
	}

	@Override
	public final JsonArrayVisitor<R> visitArray() {
		beforeVisitArray();
		return afterVisitArray(nextVisitor == null ? null : nextVisitor.visitArray());
	}

	protected void beforeVisitArray() {
	}

	protected JsonArrayVisitor<R> afterVisitArray(JsonArrayVisitor<R> jsonArrayVisitor) {
		return jsonArrayVisitor;
	}

	@Override
	public final void visitProperty(String name) {
		name = beforeVisitProperty(name);

		if (nextVisitor != null) {
			nextVisitor.visitProperty(name);
		}

		afterVisitProperty(name);
	}

	protected String beforeVisitProperty(String name) {
		return name;
	}

	protected void afterVisitProperty(String name) {
	}

	@Override
	public final void visitValue(boolean value) {
		value = beforeVisitValue(value);

		if (nextVisitor != null) {
			nextVisitor.visitValue(value);
		}

		afterVisitValue(value);
	}

	protected boolean beforeVisitValue(boolean value) {
		return value;
	}

	protected void afterVisitValue(boolean value) {
	}

	@Override
	public final void visitValue(Number value) {
		value = beforeVisitValue(value);

		if (nextVisitor != null) {
			nextVisitor.visitValue(value);
		}

		afterVisitValue(value);
	}

	protected Number beforeVisitValue(Number value) {
		return value;
	}

	protected void afterVisitValue(Number value) {
	}

	@Override
	public final void visitValue(String value) {
		value = beforeVisitValue(value);

		if (nextVisitor != null) {
			nextVisitor.visitValue(value);
		}

		afterVisitValue(value);
	}

	protected String beforeVisitValue(String value) {
		return value;
	}

	protected void afterVisitValue(String value) {
	}

	@Override
	public final void visitNullValue() {
		beforeVisitNullValue();

		if (nextVisitor != null) {
			nextVisitor.visitNullValue();
		}

		afterVisitNullValue();
	}

	protected void beforeVisitNullValue() {
	}

	protected void afterVisitNullValue() {
	}

	@Override
	public final void visitEnd() {
		beforeVisitEnd();

		if (nextVisitor != null) {
			nextVisitor.visitEnd();
		}

		afterVisitEnd();
	}

	protected void beforeVisitEnd() {
	}

	protected void afterVisitEnd() {
	}

	@Override
	public final R getVisitingResult() {
		beforeGetVisitingResult();
		return afterGetVisitingResult(nextVisitor == null ? null : nextVisitor.getVisitingResult());
	}

	protected void beforeGetVisitingResult() {
	}

	protected R afterGetVisitingResult(R visitingResult) {
		return visitingResult;
	}
}