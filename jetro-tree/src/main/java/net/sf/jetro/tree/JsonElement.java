package net.sf.jetro.tree;

import net.sf.jetro.tree.renderer.JsonRenderer;
import net.sf.jetro.visitor.JsonVisitor;

import java.io.Serializable;

public interface JsonElement extends Serializable {

	String toJson();

	String toJson(JsonRenderer renderer);

	void mergeInto(JsonVisitor<?> visitor);
}