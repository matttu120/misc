/*
-Write a computer program that simulates a traffic signal

-This particular program will simulate a 4-way intersection

-We will assume standard red, yellow and green traffic lights

-There are no protected turns (left or right)

-Timing will be specified at run-time as the following program inputs:

-North/south green light time (in seconds)

-North/south yellow light time (in seconds)

-East/west green light time (in seconds)

-East/west yellow light time (in seconds)

-The program is expected to provide output to the user on a regular basis indicating the current status of the traffic signals
Regular output should also indicate the amount of time that has elapsed since the program was started.

*/
#include <iostream>
#include <ctime>
#include <stdlib.h>

using namespace std;

/*
	void delay(int) - Since I'm not entirely sure which platform you are running on and the sleep functions are different across platforms, this function allows us to sleep for a specified amount of seconds.
*/

void delay(int seconds){
	time_t start, current;

	time(&start);
	do
	{
		time(&current);
	} while ((current - start) < seconds);
}

/*
	class Traffic - Our base class.
*/
class Traffic{

private:
	int RedDuration, YellowDuration, GreenDuration;
	int ElapsedTime;

public:
	Traffic();
	enum color { Red, Green, Yellow };
	color light;

	void setRedDuration(int);
	void setYellowDuration(int);
	void setGreenDuration(int);
	
	int getCurrentDuration();
	void cycle();
	void printState();
	void printNextState();

};

/*
	Traffic::Traffic() - Our basic constructor. 
*/
Traffic::Traffic(){
	light = Red;
	ElapsedTime = 0;
	RedDuration = 0;
	YellowDuration = 0;
	GreenDuration = 0;
}

/*
	void Traffic::cycle() - This function increments the color of the signal in the order of Red, Green, Yellow. 
*/
void Traffic::cycle(){
	light = (color)((int)light+1);
	if (light > 2)
		light = Red;
}
/*
	Traffic::setDuration(int) - These functions set the durations for each signal state based on user input.
*/
void Traffic::setRedDuration(int RDuration){
	this->RedDuration = RDuration;
}
void Traffic::setYellowDuration(int YDuration){
	this->YellowDuration = YDuration;
}
void Traffic::setGreenDuration(int GDuration){
	this->GreenDuration = GDuration;
}

/*
	int Traffic::getCurrentDuration() - This function returns the duration for the designated signal state.
*/
int Traffic::getCurrentDuration(){
	if (this->light == 0)
		return this->RedDuration;
	else if (this->light == 1){
		return this->GreenDuration;
	}
	else if (this->light == 2){
		return this->YellowDuration;
	}
}

/*
	void Traffic::printState() - This function prints the current light state of the signal.
*/
void Traffic::printState(){
	if (this->light == 0)
		cout << "Red";
	else if (this->light == 1){
		cout << "Green";
	}
	else if (this->light == 2){
		cout << "Yellow";
	}
}

/*
	void Traffic::printNextState() - This function prints the next state that the program will go to. 
*/
void Traffic::printNextState(){
	if (this->light == 0)
		cout << "Green";
	else if (this->light == 1){
		cout << "Yellow";
	}
	else if (this->light == 2){
		cout << "Red";
	}
}

/*
	void printTime(int) - This function indicates the amount of time that has elapsed since the program started.
*/
void printTime(int starttime){
	clock_t endTime = clock();
	clock_t clockTicksTaken = endTime - starttime;
	int timeInSeconds = clockTicksTaken / CLOCKS_PER_SEC;
	cout << timeInSeconds << " seconds have passed since the program was started." << endl;
}

/*
	The way I chose to design this was the following:
	1) Check if the timer has hit the designated duration for the current state.
	2) If so, call the cycle() function, cycling the states from Red->Green->Yellow.
	3) Print the current state of both signals whenever a cycle occurs, as well as the elapsed time.
*/

int main(){
	string inputstring;
	int NSGreen, NSYellow, EWGreen, EWYellow;
	cout << "Input North/South Green Light duration in seconds:";
	cin >> NSGreen;
	if (!cin){
		cout << "Please input a nonnegative integer value" << endl;
		exit (EXIT_FAILURE);
	}
	cout << "Input North/South Yellow Light duration in seconds:";
	cin >> NSYellow;
	if (!cin){
		cout << "Please input a nonnegative integer value" << endl;
		exit (EXIT_FAILURE);
	}
	cout << "Input East/West Green Light duration in seconds:";
	cin >> EWGreen;
	if (!cin){
		cout << "Please input a nonnegative integer value" << endl;
		exit(EXIT_FAILURE);
	}
	cout << "Input East/West Yellow Light duration in seconds:";
	cin >> EWYellow;
	if (!cin){
		cout << "Please input a nonnegative integer value" << endl;
		exit(EXIT_FAILURE);
	}

	//Instantiates the Green, Yellow, and Red durations for the signals. Since both directions cannot be green at the same time, I chose to make the Red Duration a function of the opposite signal.
	Traffic SignalNS;
	SignalNS.setGreenDuration(NSGreen);
	SignalNS.setYellowDuration(NSYellow);

	Traffic SignalEW;
	SignalEW.setGreenDuration(EWGreen);
	SignalEW.setYellowDuration(EWYellow);

	SignalNS.setRedDuration((EWGreen + EWYellow));
	SignalEW.setRedDuration((NSGreen + NSYellow));


	// Starts the clock, as well as starting the East/West traffic signal at Green, and the North/South light at Red.
	clock_t startTime = clock();
	SignalEW.light = static_cast<Traffic::color>(1);
	SignalNS.light = static_cast<Traffic::color>(0);
	int timer1, timer2;

	while (1){

		if (timer1 == SignalNS.getCurrentDuration()){
			cout << "North/South signal changing from ";
			SignalNS.printState();
			cout << " to ";
			SignalNS.printNextState();
			cout << "." <<endl;
			SignalNS.cycle();
			printTime(startTime);
			cout << "Signal states - N/S: ";
			SignalNS.printState();
			cout << " E/W: ";
			SignalEW.printState();
			cout << endl;
			timer1 = 0;
		}
		if (timer2 == SignalEW.getCurrentDuration()){
			cout << "East/West signal changing from ";
			SignalEW.printState();
			cout << " to ";
			SignalEW.printNextState();
			cout << "."<< endl;
			SignalEW.cycle();
			printTime(startTime);
			cout << "Signal states - N/S: ";
			SignalNS.printState();
			cout << " E/W: ";
			SignalEW.printState();
			cout << endl;
			timer2 = 0;
		}		
		timer1++;
		timer2++;
		delay(1);	
	}
}