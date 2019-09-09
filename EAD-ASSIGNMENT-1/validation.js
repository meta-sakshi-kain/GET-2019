//function to register user

function registerEmployee() {
    var fullName = document.getElementById("full_name").value;
    var email = document.getElementById("email").value;
    var contact = document.getElementById("contact").value;
    var password = document.getElementById("password").value;
    var password1 = document.getElementById("password").value;
    var confirm_password = document.getElementById("confirm_password").value;

    if (fullName == '' || contact == '' ||
        password == '' || confirm_password == '') {
        alert("Please fill all the details!!!");
        return false;
    }
    validations(fullName, email, contact, password, password1, confirm_password);
    details(fullName, email, contact);
}


function validations(fullName, email, contact, password, password1, confirm_password) {
    var empId = 'E19/1221';
    var validFullName = /[A-Z a-z]+$/;
    var min = 2;
    //check full name if it's length is less than 2 or contains non numeric
    if ((fullName.length < min)) {
        alert("Name should be of minimum 2 characters!!", function () { location.reload(); });
        return false;
    }
    if (!(fullName.match(validFullName))) {
        alert("Name should be only alphabetic!!");
        return false;
    }
    if (!(document.getElementById("M").checked) && !(document.getElementById("F").checked)) {
        alert("Please select your gender " + document.getElementById("M").checked + !(document.getElementById("F").checked));
        return false;
    }

    var atposition = email.indexOf("@");
    var dotposition = email.lastIndexOf(".");
    //check email if @ is at first position or dot is just after @ or dot does not has 2 or more succeding characters
    if (atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= email.length) {
        alert("Please enter a valid e-mail address");
        return false;
    }

    //check if contact is numeric or not and length is smaller than 8 
    if (isNaN(contact)) {
        alert("Contact should be numeric");
        return false;
    }
    if (contact.length < 9) {
        alert("Contact should be of length 8 or more")
        return false;
    }

    var validPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
    //check if password meets condition
    if (!(password.match(validPassword))) {
        alert("Password should contain 1 capital letter and should be alphanumeric!!");
        return false;
    }

    //check if password and confirm password are equal
    if (password1 != confirm_password) {
        alert("passwords do not match!!");
        return false;
    }

    var successfulReg = document.getElementById("employee_registration");
    document.getElementById("emp_Id").value = empId;
    var elem = document.querySelector('#add_vehicle');
    elem.style.visibility = 'visible';
    successfulReg.innerHTML = "<p font-weight='bold'>Congrats!! You are successfully registered. Your registration ID is" + " " + empId + "</p>";
}


var dailyInINR;
var monthlyInINR;
var yearlyInINR;
var dailyPrice;
var monthlyPrice;
var yearlyPrice;
/* set table values with specific prices according to vehicle type */
function registerVehicle(type) {
    var vehicle_name = document.getElementById("vehicle_name").value;
    var vehicle_type = document.getElementById("vehicle_type").value;
    var vehicle_number = document.getElementById("vehicle_number").value;
    if (vehicle_name == '' || vehicle_type == '' ||
        vehicle_number == 'undefined') {
        alert("Please fill all the details!!!");
        onsubmit = "return false;";

    }
    if (type == '--Select Type--') {
        alert("please select a vehicle type");
        return false;
    }
    switch (type) {
        case "cycle":
            document.getElementById("DailyPrice").innerHTML = 5;
            dailyInINR = 5;
            document.getElementById("MonthlyPrice").innerHTML = 100;
            monthlyInINR = 100;
            document.getElementById("YearlyPrice").innerHTML = 500;
            yearlyInINR = 500;
            break;
        case "motorCycle":
            document.getElementById("DailyPrice").innerHTML = 10;
            dailyInINR = 10;
            document.getElementById("MonthlyPrice").innerHTML = 200;
            monthlyInINR = 200;
            document.getElementById("YearlyPrice").innerHTML = 1000;
            yearlyInINR = 1000;
            break;
        case "fourWheeler":
            document.getElementById("DailyPrice").innerHTML = 20;
            dailyInINR = 20;
            document.getElementById("MonthlyPrice").innerHTML = 500;
            monthlyInINR = 500;
            document.getElementById("YearlyPrice").innerHTML = 3500;
            yearlyInINR = 3500;
            break;
    }

    dailyPrice = dailyInINR;
    monthlyPrice = monthlyInINR;
    yearlyPrice = yearlyInINR;
    var elem = document.querySelector('#divForPass');
    elem.style.visibility = 'visible';
    document.getElementById("add_vehicle").innerHTML = "<p font-weight='bold'>Your Vehicle has been added!!</p>"
    document.querySelector('#employee_registration').remove();
    vehicleDetails(vehicle_name, vehicle_type, vehicle_number);
}
/* changes currency into selected currency */
function changeCurrency(priceType) {
    switch (priceType) {
        case "USD":
            dailyPrice = document.getElementById("DailyPrice").innerHTML = convertToUSD(dailyInINR);
            monthlyPrice = document.getElementById("MonthlyPrice").innerHTML = convertToUSD(monthlyInINR);
            yearlyPrice = document.getElementById("YearlyPrice").innerHTML = convertToUSD(yearlyInINR);
            break;
        case "YEN":
            dailyPrice = document.getElementById("DailyPrice").innerHTML = convertToYEN(dailyInINR);
            monthlyPrice = document.getElementById("MonthlyPrice").innerHTML = convertToYEN(monthlyInINR);
            yearlyPrice = document.getElementById("YearlyPrice").innerHTML = convertToYEN(yearlyInINR);
            break;
        case "INR":
            document.getElementById("DailyPrice").innerHTML = dailyInINR;
            document.getElementById("MonthlyPrice").innerHTML = monthlyInINR;
            document.getElementById("YearlyPrice").innerHTML = yearlyInINR;
            break;
    }
}

function convertToUSD(value) {
    return (value * 0.014).toFixed(2);
}
function convertToYEN(value) {
    return (value * 1.47).toFixed(2);
}
var price; //final price to be shown
/* set final price according to plan selected */
function getPriceFunction(value) {
    switch (value) {
        case "Daily":
            price = dailyPrice;
            break;
        case "Monthly":
            price = monthlyPrice;
            break;
        case "Yearly":
            price = yearlyPrice;
            break;
    }
    return price;
}

function details(fullName, email, contact) {
    document.getElementById("username").innerHTML = fullName;
    document.getElementById("emaill").innerHTML = email;
    document.getElementById("contactdetail").innerHTML = contact;
}
function vehicleDetails(vehicle_name, vehicle_type, vehicle_number) {
    document.getElementById("vehicleName").innerHTML = vehicle_name;
    document.getElementById("vehicleType").innerHTML = vehicle_type;
    document.getElementById("vehicleNumber").innerHTML = vehicle_number;
}
//function to get pass
function getPassFunction() {
    document.querySelector('#add_vehicle').remove();
    document.querySelector('#divForPass').remove();
    document.getElementById("passprice").innerHTML = price;
    var elem = document.querySelector('#details');
    elem.style.visibility = 'visible';
}

