var dailyInINR;
var monthlyInINR;
var yearlyInINR;
var dailyPrice;
var monthlyPrice;
var yearlyPrice;
var priceInINRDaily;
var priceInINRMonthly;
var priceInINRYearly;
var priceInINR;

/* set table values with specific prices according to vehicle type */
function registerVehicle(type) {
	
	if (type == "Cycle") { 
    	
    	table.rows[1].cells[1].innerHTML = 5;
        dailyInINR = 5;
        document.getElementById("MonthlyPrice").innerHTML = 100;
        monthlyInINR = 100;
        document.getElementById("YearlyPrice").innerHTML = 500;
        yearlyInINR = 500;
    } 
    
    if (type == "MotorCycle") {
        document.getElementById("DailyPrice").innerHTML = 10;
        dailyInINR = 10;
        document.getElementById("MonthlyPrice").innerHTML = 200;
        monthlyInINR = 200;
        document.getElementById("YearlyPrice").innerHTML = 1000;
        yearlyInINR = 1000;
    }
    if (type == "Four Wheelers") {
        document.getElementById("DailyPrice").innerHTML = 20;
        dailyInINR = 20;
        document.getElementById("MonthlyPrice").innerHTML = 500;
        monthlyInINR = 500;
        document.getElementById("YearlyPrice").innerHTML = 3500;
        yearlyInINR = 3500;
    }
    dailyPrice = dailyInINR;
    monthlyPrice = monthlyInINR;
    yearlyPrice = yearlyInINR;
}
function changeCurrency(priceType) {
    if (priceType == "USD") {
    	dailyPrice = document.getElementById("DailyPrice").innerHTML = changeToUSD(dailyInINR);
        priceInINRDaily = dailyInINR;
        monthlyPrice = document.getElementById("MonthlyPrice").innerHTML =changeToUSD(monthlyInINR);
        priceInINRMonthly = monthlyInINR;
        yearlyPrice = document.getElementById("YearlyPrice").innerHTML = changeToUSD(yearlyInINR);
        priceInINRYearly = yearlyInINR;
    }
    if (priceType == "YEN") {
    	dailyPrice = document.getElementById("DailyPrice").innerHTML = changeToYEN(dailyInINR);
        priceInINRDaily = dailyInINR;
        monthlyPrice = document.getElementById("MonthlyPrice").innerHTML =changeToYEN(monthlyInINR);
        priceInINRMonthly = monthlyInINR;
        yearlyPrice = document.getElementById("YearlyPrice").innerHTML = changeToYEN(yearlyInINR);
        priceInINRYearly = yearlyInINR;
        
    }
    if (priceType == "INR") {
        document.getElementById("DailyPrice").innerHTML = dailyInINR;
        dailyPrice = dailyInINR;
        priceInINRDaily = dailyInINR;
        document.getElementById("MonthlyPrice").innerHTML = monthlyInINR;
        monthlyPrice = monthlyInINR;
        priceInINRMonthly = monthlyInINR;
        document.getElementById("YearlyPrice").innerHTML = yearlyInINR;
        yearlyPrice = yearlyInINR;
        priceInINRYearly = yearlyInINR;
    }
}
var price; //final price to be shown
/* set final price according to plan selected */
function changeToUSD(price){
	return (0.014 * price).toFixed(2);
}
function changeToYEN(price){
	return (1.47 * price).toFixed(2);
}
function getPriceFunction(value) {
    if (value == "Daily") {
        price = dailyPrice;
        priceInINR = priceInINRDaily;
    }
    if (value == "Monthly") {
        price = monthlyPrice;
        priceInINR = priceInINRMonthly;
    }
    if (value == "Yearly") {
        price = yearlyPrice;
        priceInINR = priceInINRYearly;
    }
}
function getPassFunction() {
	document.getElementById("priceInINR").value = priceInINR;
	document.getElementById("price").value = price;
}