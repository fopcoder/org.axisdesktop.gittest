package org.axisdesktop.gittest;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private String name;
	private String path;
	private int left;
	private int right;
	private List<Category> children = new ArrayList<>();

	public Category() {
	}

	public Category( String name, String path, int left, int right ) {
		this.name = name;
		this.path = path;
		this.left = left;
		this.right = right;
	}

	public Category( Category cat ) {
		this.name = cat.getName();
		this.path = cat.getPath();
		this.left = cat.getLeft();
		this.right = cat.getRight();
	}

	public Category( String[] args ) {
		this.name = args[0];
		this.path = args[1];
		this.left = Integer.valueOf( args[2] );
		this.right = Integer.valueOf( args[3] );
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath( String path ) {
		this.path = path;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft( int left ) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight( int right ) {
		this.right = right;
	}

	public List<Category> getChildren() {
		return children;
	}

	public void setChildren( List<Category> children ) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "\nCategory [name=" + name + ", path=" + path + ", left=" + left
				+ ", right=" + right + ", children=" + children + "]";
	}

}
