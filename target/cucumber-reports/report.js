$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Feature.feature");
formatter.feature({
  "name": "Verivox DSL Tariff Offers",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "DSL Result List - verify result list",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.step({
  "name": "the User is on www.verivox.de",
  "keyword": "Given "
});
formatter.match({
  "location": "VerivoxTariffDetails.the_User_is_on_www_verivox_de()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he is on the DSL calculator",
  "keyword": "When "
});
formatter.match({
  "location": "VerivoxTariffDetails.he_is_on_the_DSL_calculator()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he enters prefix/code “Ihre Vorwahl” as 030 with 16 Mbit/s bandwidth selection",
  "keyword": "And "
});
formatter.match({
  "location": "VerivoxTariffDetails.he_enters_prefix_code_Ihre_Vorwahl_as_with_Mbit_s_bandwidth_selection(int,int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on the button labeled as \"JETZT VERGLEICHEN\"",
  "keyword": "And "
});
formatter.match({
  "location": "VerivoxTariffDetails.clicks_on_the_button_labeled_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he should be able see the Result List page with all the available Tariffs",
  "keyword": "Then "
});
formatter.match({
  "location": "VerivoxTariffDetails.he_should_be_able_see_the_Result_List_page_with_all_the_available_Tariffs()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Result List - verify Offer detail page",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "the User is on the DSL Result List (follow scenario 1)",
  "keyword": "Given "
});
formatter.match({
  "location": "VerivoxTariffDetails.the_User_is_on_the_DSL_Result_List_follow_scenario(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he selects one of the listed Tariffs",
  "keyword": "When "
});
formatter.match({
  "location": "VerivoxTariffDetails.he_selects_one_of_the_listed_Tariffs()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "clicks on mehr zum Tarif button",
  "keyword": "And "
});
formatter.match({
  "location": "VerivoxTariffDetails.clicks_on_mehr_zum_Tarif_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he should be able see the details of the selected Tariff",
  "keyword": "Then "
});
formatter.match({
  "location": "VerivoxTariffDetails.he_should_be_able_see_the_details_of_the_selected_Tariff()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he should also see a button labeled as In 5 Minuten online wechseln",
  "keyword": "And "
});
formatter.match({
  "location": "VerivoxTariffDetails.he_should_also_see_a_button_labeled_as_In_Minuten_online_wechseln(int)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Lazy loading/pagination for loading the Result List",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.step({
  "name": "the User is on the DSL Result List as in scenario 1",
  "keyword": "Given "
});
formatter.match({
  "location": "PaginationLoadResults.the_User_is_on_the_DSL_Result_List_as_in_scenario(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "there are more than 20 tariffs available for the provided Vorwahl and bandwidth",
  "keyword": "When "
});
formatter.match({
  "location": "PaginationLoadResults.there_are_more_than_tariffs_available_for_the_provided_Vorwahl_and_bandwidth(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the User should a button labeled as 20 weitere laden",
  "keyword": "Then "
});
formatter.match({
  "location": "PaginationLoadResults.the_User_should_a_button_labeled_as_weitere_laden(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "WHEN he/she clicks on this button",
  "keyword": "And "
});
formatter.match({
  "location": "PaginationLoadResults.when_he_she_clicks_on_this_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the list should be appended with next 20 tariffs and so on until all Tariffs are loaded",
  "keyword": "Then "
});
formatter.match({
  "location": "PaginationLoadResults.the_list_should_be_appended_with_next_tariffs_and_so_on_until_all_Tariffs_are_loaded(int)"
});
formatter.result({
  "status": "passed"
});
});