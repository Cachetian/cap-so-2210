sap.ui.require(
    [
        'sap/fe/test/JourneyRunner',
        'skyso/skysalesorders/test/integration/FirstJourney',
		'skyso/skysalesorders/test/integration/pages/SalesOrdersList',
		'skyso/skysalesorders/test/integration/pages/SalesOrdersObjectPage'
    ],
    function(JourneyRunner, opaJourney, SalesOrdersList, SalesOrdersObjectPage) {
        'use strict';
        var JourneyRunner = new JourneyRunner({
            // start index.html in web folder
            launchUrl: sap.ui.require.toUrl('skyso/skysalesorders') + '/index.html'
        });

       
        JourneyRunner.run(
            {
                pages: { 
					onTheSalesOrdersList: SalesOrdersList,
					onTheSalesOrdersObjectPage: SalesOrdersObjectPage
                }
            },
            opaJourney.run
        );
    }
);