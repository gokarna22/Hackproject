Feature: Upcoming Bikes
  
  Scenario: New Bikes
  Given Be on zigwheels site
  When hover to new bikes and select upcoming bikes
  And select manufacture as Honda drom Dropdwon
  Then Get details of bikes under four lakh
