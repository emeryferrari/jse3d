package com.emeryferrari.jse3d;
import java.awt.*;
public class Scene {
	Object3D[] object;
	double camDist;
	double viewAngle;
	private Scene(Object3D[] object, double camDist) {
		this.object = object;
		this.camDist = camDist;
		viewAngle = 0.56;
	}
	public static Scene getInstance(ObjectTemplate preset, double camDist) {
		if (preset == ObjectTemplate.CUBE) {
			Point3D[] points = {new Point3D(1, 1, 1), new Point3D(1, 1, -1), new Point3D(1, -1, 1), new Point3D(1, -1, -1), new Point3D(-1, 1, 1), new Point3D(-1, 1, -1), new Point3D(-1, -1, 1), new Point3D(-1, -1, -1)};
			Line[] edges = {new Line(0, 1), new Line(2, 3), new Line(0, 2), new Line(1, 3), new Line(4, 5), new Line(6, 7), new Line(4, 6), new Line(5, 7), new Line(0, 4), new Line(1, 5), new Line(2, 6), new Line(3, 7)};
			Triangle[] triangles1 = {new Triangle(0, 1, 2, Color.BLUE), new Triangle(1, 2, 3, Color.BLUE)};
			Triangle[] triangles2 = {new Triangle(0, 2, 4, Color.RED), new Triangle(2, 4, 6, Color.RED)};
			Face[] faces = {new Face(triangles1), new Face(triangles2)};
			Object3D[] object = {new Object3D(points, faces, edges)};
			return new Scene(object, camDist);
		} else if (preset == ObjectTemplate.TRIANGLE){
			Point3D[] points = {new Point3D(0, 0, 0), new Point3D(2, 0, 0), new Point3D(1, 1, 0)};
			Line[] edges = {new Line(0, 1), new Line(1, 2), new Line(0, 2)};
			Triangle[] triangle = {new Triangle(0, 1, 2, Color.RED)};
			Face[] face = {new Face(triangle)};
			Object3D[] object = {new Object3D(points, face, edges)};
			return new Scene(object, camDist);
		} else if (preset == ObjectTemplate.SQUARE_PYRAMID) {
			Point3D[] points = {new Point3D(-1, -1, -1), new Point3D(1, -1, -1), new Point3D(1, -1, 1), new Point3D(-1, -1, 1), new Point3D(0, 1, 0)};
			Line[] edges = {new Line(0, 1), new Line(0, 3), new Line(2, 3), new Line(1, 2), new Line(0, 4), new Line(1, 4), new Line(2, 4), new Line(3, 4)};
			Object3D[] object = {new Object3D(points, edges)};
			return new Scene(object, camDist);
		} else {
			return null;
		}
	}
	public static Scene getInstance(Object3D[] object, double camDist) {
		return new Scene(object, camDist);
	}
	public Object3D[] getObjects() {
		return object;
	}
	public double getCameraDistance() {
		return camDist;
	}
	public void setObjects(Object3D[] object) {
		this.object = object;
	}
	public void setCameraDistance(double camDist) {
		this.camDist = camDist;
	}
}