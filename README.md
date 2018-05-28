# Pico_Placa Predictor

"Pico y Placa" used to reduce the use of cars in the city of Quito. The inputs should be a license plate number (the full number, not the last digit), a date (as a String), and a time, and the program will return whether or not that car can be on the road.

# Requirements
- JAVA 1.8
- WILDFLY 11
- PRIMEFACES 5.3

# Algoritm
A car can move if it meet the following:

- Range of time 07h00 to 09h30 and 16h00 to 19h30
- Depend of the final number of the license plate number, date and time.
- Restriction: Monday (1-2), Tuesday (3-4), Wednesday (5-6), Thursday(7-8) and Friday (9-0)

# Clone
$git clone https://github.com/gladysronquillo/Pico_Placa
