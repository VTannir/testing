package main;

import static org.junit.Assert.*;

import java.util.Random;
import static org.easymock.EasyMock.*;
import org.easymock.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyPointTest {

		MyPoint pointA;
		MyPoint pointB;
		MyPoint point;
		MyPoint pointC;
		
	@Before
	public void setUp() throws Exception {
		pointA = new MyPoint();
		pointB = new MyPoint(4d,7d);		
		pointC = new MyPoint(10d,4d);
	}

	@After
	public void tearDown() throws Exception {
	}

	// Test des constructeurs
	@Test
	public void testconstructeur1X() {
		assertEquals (0d, pointA.getX(), 0.0001);
	}
	
	@Test
	public void testconstructeur1Y() {
		assertEquals (0d, pointA.getY(), 0.0001);
	}
	
	@Test
	public void testconstructeur2X() {
		assertEquals (4d, pointB.getX(), 0.0001);
	}
		
	@Test
	public void testconstructeur2Y() {
		assertEquals (7d, pointB.getY(), 0.0001);
	}
	
	
	// test des accesseurs
	
	@Test
	public void testsetXgetX() {
		pointA.setX(3d);
		assertEquals (3d, pointA.getX(), 0.0001);
	}
	
	@Test
	public void testsetYgetY() {
		pointA.setY(5d);
		assertEquals (5d, pointA.getY(), 0.0001);
	}
	
	@Test
	public void testNaNsetYgetY() {
		pointA.setY(Double.NaN);
		assertEquals (0d, pointA.getY(), 0.0001);
	}
	
	@Test
	public void testNaNsetXgetX() {
		pointA.setX(Double.NaN);
		assertEquals (0d, pointA.getX(), 0.0001);
	}
	
	// test constructeurs 3 et opération scale
	
	@Test
	public void testconstructeur3X() {
		point = new MyPoint(pointB);
		assertEquals (4d, point.getX(), 0.0001);
			
	}
	
	@Test
	public void testconstructeur3Y() {
		point = new MyPoint(pointB);
		assertEquals (7d, point.getY(), 0.0001);
			
	}
	
	@Test
	public void testconstructeur3nullX() {
		point = new MyPoint(null);
		assertEquals (0d, point.getX(), 0.0001);
			
	}
	
	@Test
	public void testconstructeur3nullY() {
		point = new MyPoint(null);
		assertEquals (0d, point.getY(), 0.0001);		
	}
	
	
	
	@Test
	public void testScaleX() {
		point = pointB.scale(3);
		assertEquals (12d, point.getX(), 0.0001);
			
	}
	
	@Test
	public void testScaleY() {
		point = pointB.scale(3);
		assertEquals (21d, point.getY(), 0.0001);
			
	}
	
	
	// test horizontalSymmetry
	
	
	
	
	@Test
	public void testHorizontalSymmetryX() {
		point = pointC.horizontalSymmetry(pointB);
		
		assertEquals (10d, point.getX(), 0.0001);
			
	}
	
	@Test
	public void testHorizontalSymmetryY() {
		point =pointC.horizontalSymmetry(pointB);
		assertEquals (10d, point.getY(), 0.0001);
			
	}
	
//	@Test(expected=IllegalArgumentException.class)
//	public void testHorizontalSymmetry() {
//		point = pointC.horizontalSymmetry(null);
//		Assert.fail("this should be an error");
//			
//	}
	
	// test de couverture

	@Test
	public void translateX() {
		pointB.translate(3d,5d);
		assertEquals (7d, pointB.getX(), 0.0001);
			
	}
	
	@Test
	public void testranslateY() {
		pointB.translate(3d,5d);
		assertEquals (12d, pointB.getY(), 0.0001);
			
	}
	
	
	@Test
	public void testMiddlePointX() {
		point= pointB.getMiddlePoint(pointC);
		
		assertEquals (7d,point.getX(), 0.0001);	
	}
	
	@Test
	public void testMiddlePointY() {
		point= pointB.getMiddlePoint(pointC);
		
		assertEquals (5.5d,point.getY(), 0.0001);	
	}
	
	
	

	
	@Test
	public void testRotatePointX() {
		point =pointC.rotatePoint(pointA,0.174533d);
		assertEquals (9.1535d, point.getX(), 0.0001);
			
	}
	@Test
	public void testRotatePointNull() {
		point =pointC.rotatePoint(null,0.174533d);
		assertEquals (null, point);
			
	}
	
	@Test
	public void testRotatePointY() {
		point =pointC.rotatePoint(pointA,0.174533d);
		assertEquals (5.6757d, point.getY(), 0.0001);
			
	}
	
	@Test
	public void testRotatePoint0X() {
		point =pointC.rotatePoint(pointA,0);
		assertEquals (10d, point.getX(), 0.0001);
				
	}
	
	@Test
	public void testRotatePoint0Y() {
		point =pointC.rotatePoint(pointA,0);
		assertEquals (4d, point.getY(), 0.0001);
				
	}
	
	
	
	@Test
	public void testRotatePoint90X() {
		point =pointC.rotatePoint(pointA,(Math.PI/2));
		assertEquals (-4d, point.getX(), 0.0001);
	}
	
	@Test
	public void testRotatePoint90Y() {
		point =pointC.rotatePoint(pointA,(Math.PI/2));
		assertEquals (10d, point.getY(), 0.0001);
	}
	
	
	@Test
	public void testRotatePoint180X() {
		point =pointC.rotatePoint(pointA,(Math.PI));
		assertEquals (-10d, point.getX(), 0.0001);
	}
	
	@Test
	public void testRotatePoint18Y() {
		point =pointC.rotatePoint(pointA,(Math.PI));
		assertEquals (-4d, point.getY(), 0.0001);
	}
	
	
	@Test
	public void testRotatePoint260X() {
		point =pointC.rotatePoint(pointA,(Math.PI *1.5));
		assertEquals (4d, point.getX(), 0.0001);
	}
	
	@Test
	public void testRotatePoint260Y() {
		point =pointC.rotatePoint(pointA,(Math.PI *1.5));
		assertEquals (-10d, point.getY(), 0.0001);
	}
	
	
	@Test
	public void testRotatePointnegative90X() {
		point =pointC.rotatePoint(pointA,(-Math.PI/2));
		assertEquals (4d, point.getX(), 0.0001);
	}
	
	
	@Test
	public void testRotatePointnegative90Y() {
		point =pointC.rotatePoint(pointA,(-Math.PI/2));
		assertEquals (-10d, point.getY(), 0.0001);
	}
	
	@Test
	public void testCentralSymmetryX() {
		point = pointC.centralSymmetry(pointB);
		assertEquals (-2d, point.getX(), 0.0001);
				
	}
	
	@Test
	public void testCentralSymmetryY() {
		point = pointC.centralSymmetry(pointB);
		assertEquals (10d, point.getY(), 0.0001);
				
	}
		
		
	
//	@Test(expected=IllegalArgumentException.class)
//	public void testCentralSymmetryNull() {
//		point = pointC.centralSymmetry(null);
//		Assert.fail("this should be an error");	
//	}
	
	@Test
	public void testComputeAngle() {
		point = new MyPoint(0,15);
		double c =pointA.computeAngle(point);
		double resultat = Math.atan2(point.getY() - pointA.getY(),point.getX() - pointA.getX());
	
		
		
		assertEquals ( resultat , c, 0.0001);
			
	}
	
	@Test
	public void testComputeAngle2() {
		double c  =pointB.computeAngle(pointC);
		double resultat = Math.atan2(pointC.getY() - pointB.getY(),pointC.getX() - pointB.getX());
		while (resultat <0)
		{
			resultat += Math.PI;
		}
		
	
		while (c <= 0)
		{
			c += Math.PI;
		}
		
		assertEquals ( resultat , c, 0.0001);
			
	}
	
	
	@Test
	public void testComputeAngle3() {
		double c  =pointC.computeAngle(pointB);
		double resultat = Math.atan2(pointB.getY() - pointC.getY(),pointB.getX() - pointC.getX());
	
		assertEquals ( resultat , c, 0.0001);
			
	}
	
	
	
	@Test
	public void testComputeAngleNull() {
		double c  =pointB.computeAngle(null);
		
		assertEquals ( Double.NaN , c, 0.0001);
			
	}
	
//	@Test(expected=IllegalArgumentException.class)
//	public void testCentralSymmetryNULL ( ) {
//	    new MyPoint(10,20).centralSymmetry(null);
//	}
	
	
	@Test
	public void testSetPointX(){
		final Random r1 = createMock(Random.class);
		expect(r1.nextInt()).andReturn(5);
		replay(r1);		
		final Random r2  = createMock(Random.class);
		expect(r2.nextInt()).andReturn(10);
		replay(r2);
		
		pointB.setPoint(r1, r2);
		assertEquals ( 5 , pointB.getX(), 0.0001);
		verify(r1,r2);
		
	}
	
	@Test
	public void testSetPointY(){
		final Random r1 = createMock(Random.class);
		expect(r1.nextInt()).andReturn(5);
		replay(r1);		
		final Random r2  = createMock(Random.class);
		expect(r2.nextInt()).andReturn(10);
		replay(r2);
		
		pointB.setPoint(r1, r2);
		assertEquals (10 , pointB.getY(), 0.0001);
		verify(r1,r2);
		
	}
	
	
	
	
	@Test
	public void testMockTranslateX(){
		final ITranslation t1 = createMock(ITranslation.class);
		expect(t1.getTx()).andReturn(5);
		expect(t1.getTy()).andReturn(3);
		replay(t1);		
	
		pointB.translate(t1);
		assertEquals ( 9 , pointB.getX(), 0.0001);
		verify(t1);
			
	}
	
	@Test
	public void testMockTranslateY(){
		final ITranslation t1 = createMock(ITranslation.class);
		expect(t1.getTx()).andReturn(5);
		expect(t1.getTy()).andReturn(3);
		replay(t1);		
	
		pointB.translate(t1);
		assertEquals (10 , pointB.getY(), 0.0001);
		verify(t1);
			
	}
	
	
	
	@Test
	public void testTranslateNullX(){
		final ITranslation t1 = null;
		pointB.translate(t1);
		assertEquals ( 4 , pointB.getX(), 0.0001);
	}
	
	
	@Test
	public void testTranslateNullY(){
		final ITranslation t1 = null;
		pointB.translate(t1);
		assertEquals (7 , pointB.getY(), 0.0001);
		
	}
	
	
}
