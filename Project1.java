/*
* Jacob Jackson
* jijackson
* 114C
* Project 1
* UFPD Suspicion Calculator
*/

import java.util.Scanner;
public class SuspicionCalculator{
private static Scanner input;

public static void main(String[]args){
	boolean exit=false;
	int CT;
	int clon;
	int clat;
	int slon;
	int slat;
	int UFID;
	int stime;
	int HR;
	input = new Scanner(System.in);
	System.out.println("Hello and welcome to the UF suspect suspicion calculator.");
	while(!exit){

//Input Commencement
	System.out.println("Please enter the time of the crime:");
	if (input.hasNextInt()){
	CT = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}
	System.out.println("Please enter the latitude of the crime:");
	if (input.hasNextInt()){
	clat = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}
	System.out.println("Please enter the longitude of the crime:");
	if (input.hasNextInt()){
	clon = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}
	System.out.println("Please enter the student's UFID:");
	if (input.hasNextInt()){
	UFID = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}
	int digits = UFID % 100;
	System.out.println("Please enter their last timestamp:");
	if (input.hasNextInt()){
	stime = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}
	System.out.println("Please enter the latitude of the student:");
	if (input.hasNextInt()){
	slat = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}
	System.out.println("Please enter the longitude of the student:");
	if (input.hasNextInt()){
	slon = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}
	System.out.println("Please enter their heart rate:");
	if (input.hasNextInt()){
	HR = input.nextInt();
	}
	else{
		System.out.print("Invalid input. Start over. ");
		input.next();
		break;
	}

//Distance between student and crime
	int LatDif = clat - slat;
	int LonDif = clon - slon;
	double distance = java.lang.Math.sqrt(Math.pow(LatDif, 2) + Math.pow(LonDif, 2));
	String strDouble = String.format("%.1f", distance);
	System.out.println(strDouble);

//Time difference between student and crime
	int timedif = CT - stime;

//Likeliness of student committing the crime:
	String like = null;

//State of motion for student:
	String movement = null;
	String list = null;

//Students on safe list:
	if (digits <= 49 ) {
	list = "Safe List";
	if(distance < 1.0 && HR >= 100 && timedif < 30) {
	like = "Highly Likley";
	movement = "moving";
	}
	else if (distance <= 1.0 && HR >= 100 && timedif < 60 ) {
	like = "Likely";
	movement = "moving";
	}
	else if (distance > 3.0 && HR >= 100 && timedif <90) {
	like = "Unsure";
	movement = "moving";
	}
	else if (distance > 4.0 && HR < 100 && timedif < 120) {
	like = "Unlikely";
	movement = "sedentary";
	}
	else if (HR < 100){
	like = "Highly Unlikely";
	movement = "sedentary";
	}
	else if (HR > 100) {
	like = "Highly Unlikely";
	movement = "moving";
	}
	}

	//Students on Unsafe List:
	else if(digits >= 50 ) {
	list = "Unsafe List";
	if(distance <= 1.0 && timedif < 60 && HR >= 100) {
	like = "Highly Likley";
	movement = "moving";
	}
	else if(distance <= 1.0 && timedif < 60 && HR <= 100) {
	like = "Highly Likley";
	movement = "sedentary";
	}
	else if (distance <= 2.0 && HR >= 100 && timedif < 90 ) {
	like = "Likely";
	movement = "moving";
	}
	else if (distance > 2.0 && timedif <120 && HR >= 100) {
	like = "Unsure";
	movement = "moving";
	}
	else if (distance > 2.0 && timedif <120 && HR <= 100) {
	like = "Unsure";
	movement = "sedentary";
	}
	else if (distance > 3.0 && HR < 100 && timedif < 150) {
	like = "Unlikely";
	movement = "sedentary";
	}
	else if (HR < 100){
	like = "Highly Unlikely";
	movement = "sedentary";
	}
	else if (HR > 100) {
	like = "Highly Unlikely";
	movement = "moving";
	}
	}

	System.out.print("Student " + UFID + " who is on the " + list + ", and was " + strDouble +
	 " block units away, at location (" + slon + "," + slat + ") at "
	 + stime + " and determined to be " + movement + " is " + like + " to be the criminal");
	}
	}
}
