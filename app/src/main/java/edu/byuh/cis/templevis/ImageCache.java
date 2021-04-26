package edu.byuh.cis.templevis;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

/*
Instructions for maintenance

adding new temples:
1. declare a temple bitmap object at position 1 (search for positions 1)
2. load and scale bitmap in "init" method
(in the following three tasks, temples must have the same order)
3. add new temple objects into templesObejcts list in "getTempleObjectsList" method [order matters!]
4. store all images large version in "getAllImageIds" method [order matters!]
5. store all temple info in "getAllTempleInfoFileIds" method [order matters!]

in res folder:
add new temple images in drawable:
    small: 200*200
    large: 500*500
add new temple info files in raw (multiple languages)
update temple_info file, that is a summary of all temples
update all_temple_links file

adjust temple orders:
1. refer to the [order matters!] tasks (3-5) above
 */



public class ImageCache {

    private static ArrayList<Integer> allImageIds;
    private static ArrayList<Integer> allTempleInfoFileIds;
    private static ArrayList<Temple> templeObjectList;

    private static Bitmap kirtland_temple, old_nauvoo_temple, st_george_temple, logan_temple, manti_temple, salt_lake_temple, laie_hawaii_temple, cardston_alberta_temple, mesa_temple, idaho_falls_temple, bern_switzerland_temple, los_angeles_temple, hamilton_new_zealand_temple, london_england_temple, oakland_temple, ogden_utah_temple, provo_temple, washington_dc_temple, sao_paulo_brazil_temple, tokyo_japan_temple, seattle_temple, jordan_river_temple, atlanta_temple, apia_samoa_temple, nukualofa_tonga_temple, santiago_chile_temple, papeete_tahiti_temple, mexico_city_temple, boise_idaho_temple, sydney_australia_temple, manila_philippines_temple, dallas_texas_temple, taipei_taiwan_temple, guatemala_lds_temple, freiberg_germany_temple, stockholm_sweden_lds_temple, chicago_temple, johannesburg_south_africa_temple, seoul_korea_temple, lima_peru_temple, buenos_aires_argentina_temple, denver_colorado_templ, frankfurt_germany_temple, portland_oregon_temple, las_vegas_temple, toronto_temple, san_diego_california_temple, orlando_temple, bountiful_temple, hong_kong_china_temple, mount_timpanogos_utah_temple, st_louis_temple, vernal_temple, preston_england_temple, monticello_utah_temple, anchorage_alaska_temple, colonia_juarez_mexico_temple, madrid_spain_temple, bogota_colombia_temple, guayaquil_ecuador_temple, spokane_washington_temple, columbus_ohio_temple, bismark_north_dakota_temple, columbia_temple, detroit_temple, halifax_nova_scotia_lds_temple, regina_temple, billings_montana_temple, edmonton_alberta_temple, raleigh_north_carolina_temple, st_paul_temple, kona_temple, ciudad_juarez_mexico_temple, hermosillo_sonora_mexico_temple, albuquerque_temple, oaxaca_mexico_temple, tuxtla_guitierrez_mexico_temple, louisville_temple, palmyra_temple, fresno_temple, medford_temple, memphis_tennessee_temple, reno_nevada_lds_temple, cochabamba_bolivia_temple, tampico_mexico_temple, nashville_temple, villahermosa_mexico_temple, montreal_quebec_temple, san_jose_costa_rica_temple, fukuoka_japan_temple, adelaide_australia_temple, melbourne_australia_temple, suva_fiji_temple, merida_mexico_temple, veracruz_mexico_temple, baton_rouge_louisiana_temple, oklahoma_city_temple, caracas_venezuela_temple, houston_texas_temple, birmingham_alabama_temple, santo_domingo_dominican_republic_temple, boston_temple, recife_brazil_temple, porto_alegre_brazil_temple, montevideo_uruguay_temple, winter_quarters_temple, guadalajara_temple, perth_australia_temple, columbia_river_temple, snowflake_temple, lubbock_temple, monterrey_mexico_temple, campinas_brazil_temple, asuncion_paraguay_temple, nauvoo_temple, the_hague_netherlands_temple, brisbane_australia_temple, redlands_temple, accra_ghana_temple, copenhagen_denmark_temple, manhattan_temple, san_antonio_temple, aba_nigeria_temple, newport_beach_california_temple, sacramento_temple, helsinki_finland_temple, rexburg_idaho_temple, curitiba_brazil_temple, panama_city_temple, twin_falls_temple, draper_utah_temple, oquirrh_mountain_utah_temple, vancouver_temple, gila_valley_temple, cebu_philippines_temple, kyiv_ukraine_temple, san_salvador_el_salvador_temple, quetzaltenango_guatemala_temple, kansas_city_temple, manaus_brazil_temple, brigham_city_utah_temple, calgary_alberta_lds_temple, tegucigalpa_honduras_temple, gilbert_arizona_temple, fort_lauderdale_florida_temple, phoenix_arizona_temple, cordoba_argentina_temple, payson_utah_temple, trujillo_peru_temple, indianapolis_indiana_temple, tijuana_mexico_temple, provo_city_center_temple, sapporo_japan_temple, philadelphia_pennsylvania_temple, fort_collins_colorado_temple, star_valley_wyoming_temple, hartford_connecticut_temple, paris_france_temple, tucson_arizona_temple, meridian_idaho_temple, cedar_city_utah_temple, concepcion_chile_temple, barranquilla_columbia_temple, rome_italy_temple, kinshasa_temple, fortaleza_brazil_temple, haiti_temple_exterior, lisbon_portugal_temple, arequipa_peru_temple, durban_south_africa_temple;

    private static Bitmap
            abidjan_ivory_coast_temple,
            bangkok_thailand_temple,
            belem_brazil_temple,
            lima_peru_los_olivos_temple,
            pocatello_idaho_temple,
            praia_cape_verde_temple,
            puebla_mexico_temple,
            quito_ecuador_temple,
            richmond_virginia_temple,
            rio_de_janeiro_brazil_temple,
            san_juan_puerto_rico_temple,
            saratoga_springs_utah_temple,
            urdaneta_philippines_temple,
            winnipeg_manitoba_temple,
            yigo_guam_temple,
            alabang_philippines_temple,
            antofagasta_chile_temple,
            auckland_new_zealand_temple,
            bacolod_philippines_temple,
            bahia_blanca_argentina_temple,
            bengaluru_india_temple,
            benin_city_nigeria_temple,
            bentonville_arkansas_temple,
            brasilia_brazil_temple,
            budapest_hungary_temple,
            cagayan_de_oro_philippines_temple,
            coban_guatemala_temple,
            davao_philippines_temple,
            dubai_united_arab_emirates_temple,
            feather_river_california_temple,
            freetown_sierra_leone_temple,
            harare_zimbabwe_temple,
            lagos_nigeria_temple,
            layton_utah_temple,
            lubumbashi_democratic_republic_of_the_congo_temple,
            managua_nicaragua_temple,
            mcallen_texas_temple,
            mendoza_argentina_temple,
            moses_lake_washington_temple,
            nairobi_kenya_temple,
            neiafu_tonga_temple,
            okinawa_city_okinawa_temple,
            orem_utah_temple,
            pago_pago_american_samoa_temple,
            phnom_penh_cambodia_temple,
            pittsburgh_pennsylvania_temple,
            port_moresby_papua_new_guinea_temple,
            russia_temple,
            salta_argentina_temple,
            salvador_brazil_temple,
            san_pedro_sula_honduras_temple,
            syracuse_utah_temple,
            tallahassee_florida_temple,
            taylorsville_utah_temple,
            tooele_valley_utah_temple,
            washington_county_utah_temple,
            shanghai_china_temple,

    // October 2020 announced temples
            tarawa_kiribati_temple,
            port_vila_vanuatu_temple,
            lindon_utah_temple,
            greater_guatemala_city_guatemala_temple,
            sao_paulo_east_brazil_temple,
            santa_cruz_bolivia_temple,

    // April 2021 announced temples
            oslo_norway_temple,
            brussels_belgium_temple,
            vienna_austria_temple,
            kumasi_ghana_temple,
            beira_mozambique_temple,
            cape_town_south_africa_temple,
            singapore_republic_of_singapore_temple,
            belo_horizonte_brazil_temple,
            cali_colombia_temple,
            querétaro_mexico_temple,
            torreón_mexico_temple,
            helena_montana_temple,
            casper_wyoming_temple,
            grand_junction_colorado_temple,
            farmington_new_mexico_temple,
            burley_idaho_temple,
            eugene_oregon_temple,
            elko_nevada_temple,
            yorba_linda_california_temple,
            smithfield_utah_temple;

    // TODO position 1: declare new temples


    public static void init(Resources res, float w2, float h) {
        float w = w2 / 4;

        kirtland_temple = loadAndScale(res, R.drawable.kirtland_temple, w);
        old_nauvoo_temple = loadAndScale(res, R.drawable.old_nauvoo_temple, w);
        st_george_temple = loadAndScale(res, R.drawable.st_george_utah_temple, w);
        logan_temple = loadAndScale(res, R.drawable.logan_utah_temple, w);
        manti_temple = loadAndScale(res, R.drawable.manti_utah_temple, w);
        salt_lake_temple = loadAndScale(res, R.drawable.salt_lake_temple, w);
        laie_hawaii_temple = loadAndScale(res, R.drawable.laie_hawaii_temple, w);
        cardston_alberta_temple = loadAndScale(res, R.drawable.cardston_alberta_temple, w);
        mesa_temple = loadAndScale(res, R.drawable.mesa_arizona_temple, w);
        idaho_falls_temple = loadAndScale(res, R.drawable.idaho_falls_temple, w);
        bern_switzerland_temple = loadAndScale(res, R.drawable.bern_switzerland_temple, w);
        los_angeles_temple = loadAndScale(res, R.drawable.los_angeles_temple, w);
        hamilton_new_zealand_temple = loadAndScale(res, R.drawable.hamilton_new_zealand_temple, w);
        london_england_temple = loadAndScale(res, R.drawable.london_england_temple, w);
        oakland_temple = loadAndScale(res, R.drawable.oakland_temple, w);
        ogden_utah_temple = loadAndScale(res, R.drawable.ogden_utah_temple, w);
        provo_temple = loadAndScale(res, R.drawable.provo_temple, w);
        washington_dc_temple = loadAndScale(res, R.drawable.washington_dc_temple, w);
        sao_paulo_brazil_temple = loadAndScale(res, R.drawable.sao_paulo_brazil_temple, w);
        tokyo_japan_temple = loadAndScale(res, R.drawable.tokyo_japan_temple, w);
        seattle_temple = loadAndScale(res, R.drawable.seattle_temple, w);
        jordan_river_temple = loadAndScale(res, R.drawable.jordan_river_temple, w);
        atlanta_temple = loadAndScale(res, R.drawable.atlanta_temple, w);
        apia_samoa_temple = loadAndScale(res, R.drawable.apia_samoa_temple, w);
        nukualofa_tonga_temple = loadAndScale(res, R.drawable.nukualofa_tonga_temple, w);
        santiago_chile_temple = loadAndScale(res, R.drawable.santiago_chile_temple, w);
        papeete_tahiti_temple = loadAndScale(res, R.drawable.papeete_tahiti_temple, w);
        mexico_city_temple = loadAndScale(res, R.drawable.mexico_city_temple, w);
        boise_idaho_temple = loadAndScale(res, R.drawable.boise_idaho_temple, w);
        sydney_australia_temple = loadAndScale(res, R.drawable.sydney_australia_temple, w);
        manila_philippines_temple = loadAndScale(res, R.drawable.manila_philippines_temple, w);
        dallas_texas_temple = loadAndScale(res, R.drawable.dallas_texas_temple, w);
        taipei_taiwan_temple = loadAndScale(res, R.drawable.taipei_taiwan_temple, w);
        guatemala_lds_temple = loadAndScale(res, R.drawable.guatemala_lds_temple, w);
        freiberg_germany_temple = loadAndScale(res, R.drawable.freiberg_germany_temple, w);
        stockholm_sweden_lds_temple = loadAndScale(res, R.drawable.stockholm_sweden_lds_temple, w);
        chicago_temple = loadAndScale(res, R.drawable.chicago_temple, w);
        johannesburg_south_africa_temple = loadAndScale(res, R.drawable.johannesburg_south_africa_temple, w);
        seoul_korea_temple = loadAndScale(res, R.drawable.seoul_korea_temple, w);
        lima_peru_temple = loadAndScale(res, R.drawable.lima_peru_temple, w);
        buenos_aires_argentina_temple = loadAndScale(res, R.drawable.buenos_aires_argentina_temple, w);
        denver_colorado_templ = loadAndScale(res, R.drawable.denver_colorado_templ, w);
        frankfurt_germany_temple = loadAndScale(res, R.drawable.frankfurt_germany_temple, w);
        portland_oregon_temple = loadAndScale(res, R.drawable.portland_oregon_temple, w);
        las_vegas_temple = loadAndScale(res, R.drawable.las_vegas_temple, w);
        toronto_temple = loadAndScale(res, R.drawable.toronto_temple, w);
        san_diego_california_temple = loadAndScale(res, R.drawable.san_diego_california_temple, w);
        orlando_temple = loadAndScale(res, R.drawable.orlando_temple, w);
        bountiful_temple = loadAndScale(res, R.drawable.bountiful_temple, w);
        hong_kong_china_temple = loadAndScale(res, R.drawable.hong_kong_china_temple, w);
        mount_timpanogos_utah_temple = loadAndScale(res, R.drawable.mount_timpanogos_utah_temple, w);
        st_louis_temple = loadAndScale(res, R.drawable.st_louis_temple, w);
        vernal_temple = loadAndScale(res, R.drawable.vernal_temple, w);
        preston_england_temple = loadAndScale(res, R.drawable.preston_england_temple, w);
        monticello_utah_temple = loadAndScale(res, R.drawable.monticello_utah_temple, w);
        anchorage_alaska_temple = loadAndScale(res, R.drawable.anchorage_alaska_temple, w);
        colonia_juarez_mexico_temple = loadAndScale(res, R.drawable.colonia_juarez_mexico_temple, w);
        madrid_spain_temple = loadAndScale(res, R.drawable.madrid_spain_temple, w);
        bogota_colombia_temple = loadAndScale(res, R.drawable.bogota_colombia_temple, w);
        guayaquil_ecuador_temple = loadAndScale(res, R.drawable.guayaquil_ecuador_temple, w);
        spokane_washington_temple = loadAndScale(res, R.drawable.spokane_washington_temple, w);
        columbus_ohio_temple = loadAndScale(res, R.drawable.columbus_ohio_temple, w);
        bismark_north_dakota_temple = loadAndScale(res, R.drawable.bismark_north_dakota_temple, w);
        columbia_temple = loadAndScale(res, R.drawable.columbia_temple, w);
        detroit_temple = loadAndScale(res, R.drawable.detroit_temple, w);
        halifax_nova_scotia_lds_temple = loadAndScale(res, R.drawable.halifax_nova_scotia_lds_temple, w);
        regina_temple = loadAndScale(res, R.drawable.regina_temple, w);
        billings_montana_temple = loadAndScale(res, R.drawable.billings_montana_temple, w);
        edmonton_alberta_temple = loadAndScale(res, R.drawable.edmonton_alberta_temple, w);
        raleigh_north_carolina_temple = loadAndScale(res, R.drawable.raleigh_north_carolina_temple, w);
        st_paul_temple = loadAndScale(res, R.drawable.st_paul_temple, w);
        kona_temple = loadAndScale(res, R.drawable.kona_temple, w);
        ciudad_juarez_mexico_temple = loadAndScale(res, R.drawable.ciudad_juarez_mexico_temple, w);
        hermosillo_sonora_mexico_temple = loadAndScale(res, R.drawable.hermosillo_sonora_mexico_temple, w);
        albuquerque_temple = loadAndScale(res, R.drawable.albuquerque_temple, w);
        oaxaca_mexico_temple = loadAndScale(res, R.drawable.oaxaca_mexico_temple, w);
        tuxtla_guitierrez_mexico_temple = loadAndScale(res, R.drawable.tuxtla_guitierrez_mexico_temple, w);
        louisville_temple = loadAndScale(res, R.drawable.louisville_temple, w);
        palmyra_temple = loadAndScale(res, R.drawable.palmyra_temple, w);
        fresno_temple = loadAndScale(res, R.drawable.fresno_temple, w);
        medford_temple = loadAndScale(res, R.drawable.medford_temple, w);
        memphis_tennessee_temple = loadAndScale(res, R.drawable.memphis_tennessee_temple, w);
        reno_nevada_lds_temple = loadAndScale(res, R.drawable.reno_nevada_lds_temple, w);
        cochabamba_bolivia_temple = loadAndScale(res, R.drawable.cochabamba_bolivia_temple, w);
        tampico_mexico_temple = loadAndScale(res, R.drawable.tampico_mexico_temple, w);
        nashville_temple = loadAndScale(res, R.drawable.nashville_temple, w);
        villahermosa_mexico_temple = loadAndScale(res, R.drawable.villahermosa_mexico_temple, w);
        montreal_quebec_temple = loadAndScale(res, R.drawable.montreal_quebec_temple, w);
        san_jose_costa_rica_temple = loadAndScale(res, R.drawable.san_jose_costa_rica_temple, w);
        fukuoka_japan_temple = loadAndScale(res, R.drawable.fukuoka_japan_temple, w);
        adelaide_australia_temple = loadAndScale(res, R.drawable.adelaide_australia_temple, w);
        melbourne_australia_temple = loadAndScale(res, R.drawable.melbourne_australia_temple, w);
        suva_fiji_temple = loadAndScale(res, R.drawable.suva_fiji_temple, w);
        merida_mexico_temple = loadAndScale(res, R.drawable.merida_mexico_temple, w);
        veracruz_mexico_temple = loadAndScale(res, R.drawable.veracruz_mexico_temple, w);
        baton_rouge_louisiana_temple = loadAndScale(res, R.drawable.baton_rouge_louisiana_temple, w);
        oklahoma_city_temple = loadAndScale(res, R.drawable.oklahoma_city_temple, w);
        caracas_venezuela_temple = loadAndScale(res, R.drawable.caracas_venezuela_temple, w);
        houston_texas_temple = loadAndScale(res, R.drawable.houston_texas_temple, w);
        birmingham_alabama_temple = loadAndScale(res, R.drawable.birmingham_alabama_temple, w);
        santo_domingo_dominican_republic_temple = loadAndScale(res, R.drawable.santo_domingo_dominican_republic_temple, w);
        boston_temple = loadAndScale(res, R.drawable.boston_temple, w);
        recife_brazil_temple = loadAndScale(res, R.drawable.recife_brazil_temple, w);
        porto_alegre_brazil_temple = loadAndScale(res, R.drawable.porto_alegre_brazil_temple, w);
        montevideo_uruguay_temple = loadAndScale(res, R.drawable.montevideo_uruguay_temple, w);
        winter_quarters_temple = loadAndScale(res, R.drawable.winter_quarters_temple, w);
        guadalajara_temple = loadAndScale(res, R.drawable.guadalajara_temple, w);
        perth_australia_temple = loadAndScale(res, R.drawable.perth_australia_temple, w);
        columbia_river_temple = loadAndScale(res, R.drawable.columbia_river_temple, w);
        snowflake_temple = loadAndScale(res, R.drawable.snowflake_temple, w);
        lubbock_temple = loadAndScale(res, R.drawable.lubbock_temple, w);
        monterrey_mexico_temple = loadAndScale(res, R.drawable.monterrey_mexico_temple, w);
        campinas_brazil_temple = loadAndScale(res, R.drawable.campinas_brazil_temple, w);
        asuncion_paraguay_temple = loadAndScale(res, R.drawable.asuncion_paraguay_temple, w);
        nauvoo_temple = loadAndScale(res, R.drawable.nauvoo_temple, w);
        the_hague_netherlands_temple = loadAndScale(res, R.drawable.the_hague_netherlands_temple, w);
        brisbane_australia_temple = loadAndScale(res, R.drawable.brisbane_australia_temple, w);
        redlands_temple = loadAndScale(res, R.drawable.redlands_temple, w);
        accra_ghana_temple = loadAndScale(res, R.drawable.accra_ghana_temple, w);
        copenhagen_denmark_temple = loadAndScale(res, R.drawable.copenhagen_denmark_temple, w);
        manhattan_temple = loadAndScale(res, R.drawable.manhattan_temple, w);
        san_antonio_temple = loadAndScale(res, R.drawable.san_antonio_temple, w);
        aba_nigeria_temple = loadAndScale(res, R.drawable.aba_nigeria_temple, w);
        newport_beach_california_temple = loadAndScale(res, R.drawable.newport_beach_california_temple, w);
        sacramento_temple = loadAndScale(res, R.drawable.sacramento_temple, w);
        helsinki_finland_temple = loadAndScale(res, R.drawable.helsinki_finland_temple, w);
        rexburg_idaho_temple = loadAndScale(res, R.drawable.rexburg_idaho_temple, w);
        curitiba_brazil_temple = loadAndScale(res, R.drawable.curitiba_brazil_temple, w);
        panama_city_temple = loadAndScale(res, R.drawable.panama_city_temple, w);
        twin_falls_temple = loadAndScale(res, R.drawable.twin_falls_temple, w);
        draper_utah_temple = loadAndScale(res, R.drawable.draper_utah_temple, w);
        oquirrh_mountain_utah_temple = loadAndScale(res, R.drawable.oquirrh_mountain_utah_temple, w);
        vancouver_temple = loadAndScale(res, R.drawable.vancouver_temple, w);
        gila_valley_temple = loadAndScale(res, R.drawable.gila_valley_temple, w);
        cebu_philippines_temple = loadAndScale(res, R.drawable.cebu_philippines_temple, w);
        kyiv_ukraine_temple = loadAndScale(res, R.drawable.kyiv_ukraine_temple, w);
        san_salvador_el_salvador_temple = loadAndScale(res, R.drawable.san_salvador_el_salvador_temple, w);
        quetzaltenango_guatemala_temple = loadAndScale(res, R.drawable.quetzaltenango_guatemala_temple, w);
        kansas_city_temple = loadAndScale(res, R.drawable.kansas_city_temple, w);
        manaus_brazil_temple = loadAndScale(res, R.drawable.manaus_brazil_temple, w);
        brigham_city_utah_temple = loadAndScale(res, R.drawable.brigham_city_utah_temple, w);
        calgary_alberta_lds_temple = loadAndScale(res, R.drawable.calgary_alberta_lds_temple, w);
        tegucigalpa_honduras_temple = loadAndScale(res, R.drawable.tegucigalpa_honduras_temple, w);
        gilbert_arizona_temple = loadAndScale(res, R.drawable.gilbert_arizona_temple, w);
        fort_lauderdale_florida_temple = loadAndScale(res, R.drawable.fort_lauderdale_florida_temple, w);
        phoenix_arizona_temple = loadAndScale(res, R.drawable.phoenix_arizona_temple, w);
        cordoba_argentina_temple = loadAndScale(res, R.drawable.cordoba_argentina_temple, w);
        payson_utah_temple = loadAndScale(res, R.drawable.payson_utah_temple, w);
        trujillo_peru_temple = loadAndScale(res, R.drawable.trujillo_peru_temple, w);
        indianapolis_indiana_temple = loadAndScale(res, R.drawable.indianapolis_indiana_temple, w);
        tijuana_mexico_temple = loadAndScale(res, R.drawable.tijuana_mexico_temple, w);
        provo_city_center_temple = loadAndScale(res, R.drawable.provo_city_center_temple, w);
        sapporo_japan_temple = loadAndScale(res, R.drawable.sapporo_japan_temple, w);
        philadelphia_pennsylvania_temple = loadAndScale(res, R.drawable.philadelphia_pennsylvania_temple, w);
        fort_collins_colorado_temple = loadAndScale(res, R.drawable.fort_collins_colorado_temple, w);
        star_valley_wyoming_temple = loadAndScale(res, R.drawable.star_valley_wyoming_temple, w);
        hartford_connecticut_temple = loadAndScale(res, R.drawable.hartford_connecticut_temple, w);
        paris_france_temple = loadAndScale(res, R.drawable.paris_france_temple, w);
        tucson_arizona_temple = loadAndScale(res, R.drawable.tucson_arizona_temple, w);
        meridian_idaho_temple = loadAndScale(res, R.drawable.meridian_idaho_temple, w);
        cedar_city_utah_temple = loadAndScale(res, R.drawable.cedar_city_utah_temple, w);
        concepcion_chile_temple = loadAndScale(res, R.drawable.concepcion_chile_temple, w);
        barranquilla_columbia_temple = loadAndScale(res, R.drawable.barranquilla_columbia_temple, w);
        rome_italy_temple = loadAndScale(res, R.drawable.rome_italy_temple, w);
        kinshasa_temple = loadAndScale(res, R.drawable.kinshasa_temple, w);
        fortaleza_brazil_temple = loadAndScale(res, R.drawable.fortaleza_brazil_temple, w);
        haiti_temple_exterior = loadAndScale(res, R.drawable.haiti_temple_exterior, w);
        lisbon_portugal_temple = loadAndScale(res, R.drawable.lisbon_portugal_temple, w);
        arequipa_peru_temple = loadAndScale(res, R.drawable.arequipa_peru_temple, w);
        durban_south_africa_temple = loadAndScale(res, R.drawable.durban_south_africa_temple, w);

        abidjan_ivory_coast_temple = loadAndScale(res, R.drawable.abidjan_ivory_coast_temple, w);
        bangkok_thailand_temple = loadAndScale(res, R.drawable.bangkok_thailand_temple, w);
        belem_brazil_temple = loadAndScale(res, R.drawable.belem_brazil_temple, w);
        lima_peru_los_olivos_temple = loadAndScale(res, R.drawable.lima_peru_los_olivos_temple, w);
        pocatello_idaho_temple = loadAndScale(res, R.drawable.pocatello_idaho_temple, w);
        praia_cape_verde_temple = loadAndScale(res, R.drawable.praia_cape_verde_temple, w);
        puebla_mexico_temple = loadAndScale(res, R.drawable.puebla_mexico_temple, w);
        quito_ecuador_temple = loadAndScale(res, R.drawable.quito_ecuador_temple, w);
        richmond_virginia_temple = loadAndScale(res, R.drawable.richmond_virginia_temple, w);
        rio_de_janeiro_brazil_temple = loadAndScale(res, R.drawable.rio_de_janeiro_brazil_temple, w);
        san_juan_puerto_rico_temple = loadAndScale(res, R.drawable.san_juan_puerto_rico_temple, w);
        saratoga_springs_utah_temple = loadAndScale(res, R.drawable.saratoga_springs_utah_temple, w);
        urdaneta_philippines_temple = loadAndScale(res, R.drawable.urdaneta_philippines_temple, w);
        winnipeg_manitoba_temple = loadAndScale(res, R.drawable.winnipeg_manitoba_temple, w);
        yigo_guam_temple = loadAndScale(res, R.drawable.yigo_guam_temple, w);
        alabang_philippines_temple = loadAndScale(res, R.drawable.alabang_philippines_temple, w);
        antofagasta_chile_temple = loadAndScale(res, R.drawable.antofagasta_chile_temple, w);
        auckland_new_zealand_temple = loadAndScale(res, R.drawable.auckland_new_zealand_temple, w);
        bacolod_philippines_temple = loadAndScale(res, R.drawable.bacolod_philippines_temple, w);
        bahia_blanca_argentina_temple = loadAndScale(res, R.drawable.bahia_blanca_argentina_temple, w);
        bengaluru_india_temple = loadAndScale(res, R.drawable.bengaluru_india_temple, w);
        benin_city_nigeria_temple = loadAndScale(res, R.drawable.benin_city_nigeria_temple, w);
        bentonville_arkansas_temple = loadAndScale(res, R.drawable.bentonville_arkansas_temple, w);
        brasilia_brazil_temple = loadAndScale(res, R.drawable.brasilia_brazil_temple, w);
        budapest_hungary_temple = loadAndScale(res, R.drawable.budapest_hungary_temple, w);
        cagayan_de_oro_philippines_temple = loadAndScale(res, R.drawable.cagayan_de_oro_philippines_temple, w);
        coban_guatemala_temple = loadAndScale(res, R.drawable.coban_guatemala_temple, w);
        davao_philippines_temple = loadAndScale(res, R.drawable.davao_philippines_temple, w);
        dubai_united_arab_emirates_temple = loadAndScale(res, R.drawable.dubai_united_arab_emirates_temple, w);
        feather_river_california_temple = loadAndScale(res, R.drawable.feather_river_california_temple, w);
        freetown_sierra_leone_temple = loadAndScale(res, R.drawable.freetown_sierra_leone_temple, w);
        harare_zimbabwe_temple = loadAndScale(res, R.drawable.harare_zimbabwe_temple, w);
        lagos_nigeria_temple = loadAndScale(res, R.drawable.lagos_nigeria_temple, w);
        layton_utah_temple = loadAndScale(res, R.drawable.layton_utah_temple, w);
        lubumbashi_democratic_republic_of_the_congo_temple = loadAndScale(res, R.drawable.lubumbashi_democratic_republic_of_the_congo_temple, w);
        managua_nicaragua_temple = loadAndScale(res, R.drawable.managua_nicaragua_temple, w);
        mcallen_texas_temple = loadAndScale(res, R.drawable.mcallen_texas_temple, w);
        mendoza_argentina_temple = loadAndScale(res, R.drawable.mendoza_argentina_temple, w);
        moses_lake_washington_temple = loadAndScale(res, R.drawable.moses_lake_washington_temple, w);
        nairobi_kenya_temple = loadAndScale(res, R.drawable.nairobi_kenya_temple, w);
        neiafu_tonga_temple = loadAndScale(res, R.drawable.neiafu_tonga_temple, w);
        okinawa_city_okinawa_temple = loadAndScale(res, R.drawable.okinawa_city_okinawa_temple, w);
        orem_utah_temple = loadAndScale(res, R.drawable.orem_utah_temple, w);
        pago_pago_american_samoa_temple = loadAndScale(res, R.drawable.pago_pago_american_samoa_temple, w);
        phnom_penh_cambodia_temple = loadAndScale(res, R.drawable.phnom_penh_cambodia_temple, w);
        pittsburgh_pennsylvania_temple = loadAndScale(res, R.drawable.pittsburgh_pennsylvania_temple, w);
        port_moresby_papua_new_guinea_temple = loadAndScale(res, R.drawable.port_moresby_papua_new_guinea_temple, w);
        russia_temple = loadAndScale(res, R.drawable.russia_temple, w);
        salta_argentina_temple = loadAndScale(res, R.drawable.salta_argentina_temple, w);
        salvador_brazil_temple = loadAndScale(res, R.drawable.salvador_brazil_temple, w);
        san_pedro_sula_honduras_temple = loadAndScale(res, R.drawable.san_pedro_sula_honduras_temple, w);
        syracuse_utah_temple = loadAndScale(res, R.drawable.syracuse_utah_temple, w);
        tallahassee_florida_temple = loadAndScale(res, R.drawable.tallahassee_florida_temple, w);
        taylorsville_utah_temple = loadAndScale(res, R.drawable.taylorsville_utah_temple, w);
        tooele_valley_utah_temple = loadAndScale(res, R.drawable.tooele_valley_utah_temple, w);
        washington_county_utah_temple = loadAndScale(res, R.drawable.washington_county_utah_temple, w);

        // October 2020 announced temples

        tarawa_kiribati_temple = loadAndScale(res, R.drawable.tarawa_kiribati_temple, w);
        port_vila_vanuatu_temple = loadAndScale(res, R.drawable.port_vila_vanuatu_temple, w);
        lindon_utah_temple = loadAndScale(res, R.drawable.lindon_utah_temple, w);
        greater_guatemala_city_guatemala_temple = loadAndScale(res, R.drawable.greater_guatemala_city_guatemala_temple, w);
        sao_paulo_east_brazil_temple = loadAndScale(res, R.drawable.sao_paulo_east_brazil_temple, w);
        santa_cruz_bolivia_temple = loadAndScale(res, R.drawable.santa_cruz_bolivia_temple, w);

        //shanghai_china_temple = loadAndScale(res,R.drawable.shanghai_china_temple,w);

    }

    private static Bitmap loadAndScale(Resources res, int id, float newWidth) {
        Bitmap original = BitmapFactory.decodeResource(res, id);
        float aspectRatio = (float)original.getHeight()/(float)original.getWidth();
        float newHeight = newWidth * aspectRatio;
        return Bitmap.createScaledBitmap(original, (int)newWidth, (int)newHeight, true);
    }

    public static ArrayList<Temple> getTempleObjectsList() {

        templeObjectList = new ArrayList<>();

        templeObjectList.add(new Temple(kirtland_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(old_nauvoo_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(st_george_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(logan_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(manti_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(salt_lake_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(laie_hawaii_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(cardston_alberta_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(mesa_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(idaho_falls_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bern_switzerland_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(los_angeles_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(hamilton_new_zealand_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(london_england_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(oakland_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(ogden_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(provo_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(washington_dc_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(sao_paulo_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tokyo_japan_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(seattle_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(jordan_river_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(atlanta_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(apia_samoa_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(nukualofa_tonga_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(santiago_chile_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(papeete_tahiti_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(mexico_city_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(boise_idaho_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(sydney_australia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(manila_philippines_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(dallas_texas_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(taipei_taiwan_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(guatemala_lds_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(freiberg_germany_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(stockholm_sweden_lds_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(chicago_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(johannesburg_south_africa_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(seoul_korea_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(lima_peru_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(buenos_aires_argentina_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(denver_colorado_templ, 0f, 0f, 0f));
        templeObjectList.add(new Temple(frankfurt_germany_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(portland_oregon_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(las_vegas_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(toronto_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(san_diego_california_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(orlando_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bountiful_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(hong_kong_china_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(mount_timpanogos_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(st_louis_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(vernal_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(preston_england_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(monticello_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(anchorage_alaska_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(colonia_juarez_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(madrid_spain_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bogota_colombia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(guayaquil_ecuador_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(spokane_washington_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(columbus_ohio_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bismark_north_dakota_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(columbia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(detroit_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(halifax_nova_scotia_lds_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(regina_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(billings_montana_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(edmonton_alberta_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(raleigh_north_carolina_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(st_paul_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(kona_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(ciudad_juarez_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(hermosillo_sonora_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(albuquerque_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(oaxaca_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tuxtla_guitierrez_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(louisville_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(palmyra_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(fresno_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(medford_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(memphis_tennessee_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(reno_nevada_lds_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(cochabamba_bolivia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tampico_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(nashville_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(villahermosa_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(montreal_quebec_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(san_jose_costa_rica_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(fukuoka_japan_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(adelaide_australia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(melbourne_australia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(suva_fiji_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(merida_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(veracruz_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(baton_rouge_louisiana_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(oklahoma_city_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(caracas_venezuela_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(houston_texas_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(birmingham_alabama_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(santo_domingo_dominican_republic_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(boston_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(recife_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(porto_alegre_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(montevideo_uruguay_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(winter_quarters_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(guadalajara_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(perth_australia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(columbia_river_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(snowflake_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(lubbock_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(monterrey_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(campinas_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(asuncion_paraguay_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(nauvoo_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(the_hague_netherlands_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(brisbane_australia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(redlands_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(accra_ghana_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(copenhagen_denmark_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(manhattan_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(san_antonio_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(aba_nigeria_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(newport_beach_california_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(sacramento_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(helsinki_finland_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(rexburg_idaho_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(curitiba_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(panama_city_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(twin_falls_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(draper_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(oquirrh_mountain_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(vancouver_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(gila_valley_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(cebu_philippines_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(kyiv_ukraine_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(san_salvador_el_salvador_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(quetzaltenango_guatemala_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(kansas_city_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(manaus_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(brigham_city_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(calgary_alberta_lds_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tegucigalpa_honduras_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(gilbert_arizona_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(fort_lauderdale_florida_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(phoenix_arizona_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(cordoba_argentina_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(payson_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(trujillo_peru_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(indianapolis_indiana_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tijuana_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(provo_city_center_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(sapporo_japan_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(philadelphia_pennsylvania_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(fort_collins_colorado_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(star_valley_wyoming_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(hartford_connecticut_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(paris_france_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tucson_arizona_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(meridian_idaho_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(cedar_city_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(concepcion_chile_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(barranquilla_columbia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(rome_italy_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(kinshasa_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(fortaleza_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(haiti_temple_exterior, 0f, 0f, 0f));
        templeObjectList.add(new Temple(lisbon_portugal_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(arequipa_peru_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(durban_south_africa_temple, 0f, 0f, 0f));

        // under construction
        templeObjectList.add(new Temple(winnipeg_manitoba_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(rio_de_janeiro_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(abidjan_ivory_coast_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(urdaneta_philippines_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bangkok_thailand_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(pocatello_idaho_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(yigo_guam_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(praia_cape_verde_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(san_juan_puerto_rico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(quito_ecuador_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(lima_peru_los_olivos_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(belem_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(saratoga_springs_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(puebla_mexico_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(richmond_virginia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(layton_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(alabang_philippines_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(auckland_new_zealand_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(feather_river_california_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(orem_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(san_pedro_sula_honduras_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(brasilia_brazil_temple, 0f, 0f, 0f));

        // announced
        templeObjectList.add(new Temple(harare_zimbabwe_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(nairobi_kenya_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bengaluru_india_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(salta_argentina_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(managua_nicaragua_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(cagayan_de_oro_philippines_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(russia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(washington_county_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(phnom_penh_cambodia_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(mendoza_argentina_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(salvador_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(lagos_nigeria_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(davao_philippines_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tooele_valley_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(moses_lake_washington_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(pago_pago_american_samoa_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(okinawa_city_okinawa_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(neiafu_tonga_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(antofagasta_chile_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(budapest_hungary_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(mcallen_texas_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(taylorsville_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(freetown_sierra_leone_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(port_moresby_papua_new_guinea_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bentonville_arkansas_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bacolod_philippines_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(coban_guatemala_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(bahia_blanca_argentina_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(tallahassee_florida_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(lubumbashi_democratic_republic_of_the_congo_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(pittsburgh_pennsylvania_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(benin_city_nigeria_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(syracuse_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(dubai_united_arab_emirates_temple, 0f, 0f, 0f));

        // October 2020 announced temples

        templeObjectList.add(new Temple(tarawa_kiribati_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(port_vila_vanuatu_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(lindon_utah_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(greater_guatemala_city_guatemala_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(sao_paulo_east_brazil_temple, 0f, 0f, 0f));
        templeObjectList.add(new Temple(santa_cruz_bolivia_temple, 0f, 0f, 0f));

        // April 2021 announced temples

        return templeObjectList;
    }

    public static ArrayList<Integer> getAllImageIds() {

        allImageIds = new ArrayList<>();

        allImageIds.add(R.drawable.kirtland_temple_large);
        allImageIds.add(R.drawable.old_nauvoo_temple_large);
        allImageIds.add(R.drawable.st_george_utah_temple_large);
        allImageIds.add(R.drawable.logan_utah_temple_large);
        allImageIds.add(R.drawable.manti_utah_temple_large);
        allImageIds.add(R.drawable.salt_lake_temple_large);
        allImageIds.add(R.drawable.laie_hawaii_temple_large);
        allImageIds.add(R.drawable.cardston_alberta_temple_large);
        allImageIds.add(R.drawable.mesa_arizona_temple_large);
        allImageIds.add(R.drawable.idaho_falls_temple_large);
        allImageIds.add(R.drawable.bern_switzerland_temple_large);
        allImageIds.add(R.drawable.los_angeles_temple_large);
        allImageIds.add(R.drawable.hamilton_new_zealand_temple_large);
        allImageIds.add(R.drawable.london_england_temple_large);
        allImageIds.add(R.drawable.oakland_temple_large);
        allImageIds.add(R.drawable.ogden_utah_temple_large);
        allImageIds.add(R.drawable.provo_temple_large);
        allImageIds.add(R.drawable.washington_dc_temple_large);
        allImageIds.add(R.drawable.sao_paulo_brazil_temple_large);
        allImageIds.add(R.drawable.tokyo_japan_temple_large);
        allImageIds.add(R.drawable.seattle_temple_large);
        allImageIds.add(R.drawable.jordan_river_temple_large);
        allImageIds.add(R.drawable.atlanta_temple_large);
        allImageIds.add(R.drawable.apia_samoa_temple_large);
        allImageIds.add(R.drawable.nukualofa_tonga_temple_large);
        allImageIds.add(R.drawable.santiago_chile_temple_large);
        allImageIds.add(R.drawable.papeete_tahiti_temple_large);
        allImageIds.add(R.drawable.mexico_city_temple_large);
        allImageIds.add(R.drawable.boise_idaho_temple_large);
        allImageIds.add(R.drawable.sydney_australia_temple_large);
        allImageIds.add(R.drawable.manila_philippines_temple_large);
        allImageIds.add(R.drawable.dallas_texas_temple_large);
        allImageIds.add(R.drawable.taipei_taiwan_temple_large);
        allImageIds.add(R.drawable.guatemala_lds_temple_large);
        allImageIds.add(R.drawable.freiberg_germany_temple_large);
        allImageIds.add(R.drawable.stockholm_sweden_lds_temple_large);
        allImageIds.add(R.drawable.chicago_temple_large);
        allImageIds.add(R.drawable.johannesburg_south_africa_temple_large);
        allImageIds.add(R.drawable.seoul_korea_temple_large);
        allImageIds.add(R.drawable.lima_peru_temple_large);
        allImageIds.add(R.drawable.buenos_aires_argentina_temple_large);
        allImageIds.add(R.drawable.denver_colorado_templ_large);
        allImageIds.add(R.drawable.frankfurt_germany_temple_large);
        allImageIds.add(R.drawable.portland_oregon_temple_large);
        allImageIds.add(R.drawable.las_vegas_temple_large);
        allImageIds.add(R.drawable.toronto_temple_large);
        allImageIds.add(R.drawable.san_diego_california_temple_large);
        allImageIds.add(R.drawable.orlando_temple_large);
        allImageIds.add(R.drawable.bountiful_temple_large);
        allImageIds.add(R.drawable.hong_kong_china_temple_large);
        allImageIds.add(R.drawable.mount_timpanogos_utah_temple_large);
        allImageIds.add(R.drawable.st_louis_temple_large);
        allImageIds.add(R.drawable.vernal_temple_large);
        allImageIds.add(R.drawable.preston_england_temple_large);
        allImageIds.add(R.drawable.monticello_utah_temple_large);
        allImageIds.add(R.drawable.anchorage_alaska_temple_large);
        allImageIds.add(R.drawable.colonia_juarez_mexico_temple_large);
        allImageIds.add(R.drawable.madrid_spain_temple_large);
        allImageIds.add(R.drawable.bogota_colombia_temple_large);
        allImageIds.add(R.drawable.guayaquil_ecuador_temple_large);
        allImageIds.add(R.drawable.spokane_washington_temple_large);
        allImageIds.add(R.drawable.columbus_ohio_temple_large);
        allImageIds.add(R.drawable.bismark_north_dakota_temple_large);
        allImageIds.add(R.drawable.columbia_temple_large);
        allImageIds.add(R.drawable.detroit_temple_large);
        allImageIds.add(R.drawable.halifax_nova_scotia_lds_temple_large);
        allImageIds.add(R.drawable.regina_temple_large);
        allImageIds.add(R.drawable.billings_montana_temple_large);
        allImageIds.add(R.drawable.edmonton_alberta_temple_large);
        allImageIds.add(R.drawable.raleigh_north_carolina_temple_large);
        allImageIds.add(R.drawable.st_paul_temple_large);
        allImageIds.add(R.drawable.kona_temple_large);
        allImageIds.add(R.drawable.ciudad_juarez_mexico_temple_large);
        allImageIds.add(R.drawable.hermosillo_sonora_mexico_temple_large);
        allImageIds.add(R.drawable.albuquerque_temple_large);
        allImageIds.add(R.drawable.oaxaca_mexico_temple_large);
        allImageIds.add(R.drawable.tuxtla_guitierrez_mexico_temple_large);
        allImageIds.add(R.drawable.louisville_temple_large);
        allImageIds.add(R.drawable.palmyra_temple_large);
        allImageIds.add(R.drawable.fresno_temple_large);
        allImageIds.add(R.drawable.medford_temple_large);
        allImageIds.add(R.drawable.memphis_tennessee_temple_large);
        allImageIds.add(R.drawable.reno_nevada_lds_temple_large);
        allImageIds.add(R.drawable.cochabamba_bolivia_temple_large);
        allImageIds.add(R.drawable.tampico_mexico_temple_large);
        allImageIds.add(R.drawable.nashville_temple_large);
        allImageIds.add(R.drawable.villahermosa_mexico_temple_large);
        allImageIds.add(R.drawable.montreal_quebec_temple_large);
        allImageIds.add(R.drawable.san_jose_costa_rica_temple_large);
        allImageIds.add(R.drawable.fukuoka_japan_temple_large);
        allImageIds.add(R.drawable.adelaide_australia_temple_large);
        allImageIds.add(R.drawable.melbourne_australia_temple_large);
        allImageIds.add(R.drawable.suva_fiji_temple_large);
        allImageIds.add(R.drawable.merida_mexico_temple_large);
        allImageIds.add(R.drawable.veracruz_mexico_temple_large);
        allImageIds.add(R.drawable.baton_rouge_louisiana_temple_large);
        allImageIds.add(R.drawable.oklahoma_city_temple_large);
        allImageIds.add(R.drawable.caracas_venezuela_temple_large);
        allImageIds.add(R.drawable.houston_texas_temple_large);
        allImageIds.add(R.drawable.birmingham_alabama_temple_large);
        allImageIds.add(R.drawable.santo_domingo_dominican_republic_temple_large);
        allImageIds.add(R.drawable.boston_temple_large);
        allImageIds.add(R.drawable.recife_brazil_temple_large);
        allImageIds.add(R.drawable.porto_alegre_brazil_temple_large);
        allImageIds.add(R.drawable.montevideo_uruguay_temple_large);
        allImageIds.add(R.drawable.winter_quarters_temple_large);
        allImageIds.add(R.drawable.guadalajara_temple_large);
        allImageIds.add(R.drawable.perth_australia_temple_large);
        allImageIds.add(R.drawable.columbia_river_temple_large);
        allImageIds.add(R.drawable.snowflake_temple_large);
        allImageIds.add(R.drawable.lubbock_temple_large);
        allImageIds.add(R.drawable.monterrey_mexico_temple_large);
        allImageIds.add(R.drawable.campinas_brazil_temple_large);
        allImageIds.add(R.drawable.asuncion_paraguay_temple_large);
        allImageIds.add(R.drawable.nauvoo_temple_large);
        allImageIds.add(R.drawable.the_hague_netherlands_temple_large);
        allImageIds.add(R.drawable.brisbane_australia_temple_large);
        allImageIds.add(R.drawable.redlands_temple_large);
        allImageIds.add(R.drawable.accra_ghana_temple_large);
        allImageIds.add(R.drawable.copenhagen_denmark_temple_large);
        allImageIds.add(R.drawable.manhattan_temple_large);
        allImageIds.add(R.drawable.san_antonio_temple_large);
        allImageIds.add(R.drawable.aba_nigeria_temple_large);
        allImageIds.add(R.drawable.newport_beach_california_temple_large);
        allImageIds.add(R.drawable.sacramento_temple_large);
        allImageIds.add(R.drawable.helsinki_finland_temple_large);
        allImageIds.add(R.drawable.rexburg_idaho_temple_large);
        allImageIds.add(R.drawable.curitiba_brazil_temple_large);
        allImageIds.add(R.drawable.panama_city_temple_large);
        allImageIds.add(R.drawable.twin_falls_temple_large);
        allImageIds.add(R.drawable.draper_utah_temple_large);
        allImageIds.add(R.drawable.oquirrh_mountain_utah_temple_large);
        allImageIds.add(R.drawable.vancouver_temple_large);
        allImageIds.add(R.drawable.gila_valley_temple_large);
        allImageIds.add(R.drawable.cebu_philippines_temple_large);
        allImageIds.add(R.drawable.kyiv_ukraine_temple_large);
        allImageIds.add(R.drawable.san_salvador_el_salvador_temple_large);
        allImageIds.add(R.drawable.quetzaltenango_guatemala_temple_large);
        allImageIds.add(R.drawable.kansas_city_temple_large);
        allImageIds.add(R.drawable.manaus_brazil_temple_large);
        allImageIds.add(R.drawable.brigham_city_utah_temple_large);
        allImageIds.add(R.drawable.calgary_alberta_lds_temple_large);
        allImageIds.add(R.drawable.tegucigalpa_honduras_temple_large);
        allImageIds.add(R.drawable.gilbert_arizona_temple_large);
        allImageIds.add(R.drawable.fort_lauderdale_florida_temple_large);
        allImageIds.add(R.drawable.phoenix_arizona_temple_large);
        allImageIds.add(R.drawable.cordoba_argentina_temple_large);
        allImageIds.add(R.drawable.payson_utah_temple_large);
        allImageIds.add(R.drawable.trujillo_peru_temple_large);
        allImageIds.add(R.drawable.indianapolis_indiana_temple_large);
        allImageIds.add(R.drawable.tijuana_mexico_temple_large);
        allImageIds.add(R.drawable.provo_city_center_temple_large);
        allImageIds.add(R.drawable.sapporo_japan_temple_large);
        allImageIds.add(R.drawable.philadelphia_pennsylvania_temple_large);
        allImageIds.add(R.drawable.fort_collins_colorado_temple_large);
        allImageIds.add(R.drawable.star_valley_wyoming_temple_large);
        allImageIds.add(R.drawable.hartford_connecticut_temple_large);
        allImageIds.add(R.drawable.paris_france_temple_large);
        allImageIds.add(R.drawable.tucson_arizona_temple_large);
        allImageIds.add(R.drawable.meridian_idaho_temple_large);
        allImageIds.add(R.drawable.cedar_city_utah_temple_large);
        allImageIds.add(R.drawable.concepcion_chile_temple_large);
        allImageIds.add(R.drawable.barranquilla_columbia_temple_large);
        allImageIds.add(R.drawable.rome_italy_temple_large);
        allImageIds.add(R.drawable.kinshasa_temple_large);
        allImageIds.add(R.drawable.fortaleza_brazil_temple_large);
        allImageIds.add(R.drawable.haiti_temple_exterior_large);
        allImageIds.add(R.drawable.lisbon_portugal_temple_large);
        allImageIds.add(R.drawable.arequipa_peru_temple_large);
        allImageIds.add(R.drawable.durban_south_africa_temple_large);

        //temples under construction
        allImageIds.add(R.drawable.winnipeg_manitoba_temple_large);
        allImageIds.add(R.drawable.rio_de_janeiro_brazil_temple_large);
        allImageIds.add(R.drawable.abidjan_ivory_coast_temple_large);
        allImageIds.add(R.drawable.urdaneta_philippines_temple_large);
        allImageIds.add(R.drawable.bangkok_thailand_temple_large);
        allImageIds.add(R.drawable.pocatello_idaho_temple_large);
        allImageIds.add(R.drawable.yigo_guam_temple_large);
        allImageIds.add(R.drawable.praia_cape_verde_temple_large);
        allImageIds.add(R.drawable.san_juan_puerto_rico_temple_large);
        allImageIds.add(R.drawable.quito_ecuador_temple_large);
        allImageIds.add(R.drawable.lima_peru_los_olivos_temple_large);
        allImageIds.add(R.drawable.belem_brazil_temple_large);
        allImageIds.add(R.drawable.saratoga_springs_utah_temple_large);
        allImageIds.add(R.drawable.puebla_mexico_temple_large);
        allImageIds.add(R.drawable.richmond_virginia_temple_large);
        allImageIds.add(R.drawable.layton_utah_temple_large);
        allImageIds.add(R.drawable.alabang_philippines_temple_large);
        allImageIds.add(R.drawable.auckland_new_zealand_temple_large);
        allImageIds.add(R.drawable.feather_river_california_temple_large);
        allImageIds.add(R.drawable.orem_utah_temple_large);
        allImageIds.add(R.drawable.san_pedro_sula_honduras_temple_large);
        allImageIds.add(R.drawable.brasilia_brazil_temple_large);

        //announced temples
        allImageIds.add(R.drawable.harare_zimbabwe_temple_large);
        allImageIds.add(R.drawable.nairobi_kenya_temple_large);
        allImageIds.add(R.drawable.bengaluru_india_temple_large);
        allImageIds.add(R.drawable.salta_argentina_temple_large);
        allImageIds.add(R.drawable.managua_nicaragua_temple_large);
        allImageIds.add(R.drawable.cagayan_de_oro_philippines_temple_large);
        allImageIds.add(R.drawable.russia_temple_large);
        allImageIds.add(R.drawable.washington_county_utah_temple_large);
        allImageIds.add(R.drawable.phnom_penh_cambodia_temple_large);
        allImageIds.add(R.drawable.mendoza_argentina_temple_large);
        allImageIds.add(R.drawable.salvador_brazil_temple_large);
        allImageIds.add(R.drawable.lagos_nigeria_temple_large);
        allImageIds.add(R.drawable.davao_philippines_temple_large);
        allImageIds.add(R.drawable.tooele_valley_utah_temple_large);
        allImageIds.add(R.drawable.moses_lake_washington_temple_large);
        allImageIds.add(R.drawable.pago_pago_american_samoa_temple_large);
        allImageIds.add(R.drawable.okinawa_city_okinawa_temple_large);
        allImageIds.add(R.drawable.neiafu_tonga_temple_large);
        allImageIds.add(R.drawable.antofagasta_chile_temple_large);
        allImageIds.add(R.drawable.budapest_hungary_temple_large);
        allImageIds.add(R.drawable.mcallen_texas_temple_large);
        allImageIds.add(R.drawable.taylorsville_utah_temple_large);
        allImageIds.add(R.drawable.freetown_sierra_leone_temple_large);
        allImageIds.add(R.drawable.port_moresby_papua_new_guinea_temple_large);
        allImageIds.add(R.drawable.bentonville_arkansas_temple_large);
        allImageIds.add(R.drawable.bacolod_philippines_temple_large);
        allImageIds.add(R.drawable.coban_guatemala_temple_large);
        allImageIds.add(R.drawable.bahia_blanca_argentina_temple_large);
        allImageIds.add(R.drawable.tallahassee_florida_temple_large);
        allImageIds.add(R.drawable.lubumbashi_democratic_republic_of_the_congo_temple_large);
        allImageIds.add(R.drawable.pittsburgh_pennsylvania_temple_large);
        allImageIds.add(R.drawable.benin_city_nigeria_temple_large);
        allImageIds.add(R.drawable.syracuse_utah_temple_large);
        allImageIds.add(R.drawable.dubai_united_arab_emirates_temple_large);

        //allImageIds.add(R.drawable.shanghai_china_temple_large);

        // October 2020 announced temples

        allImageIds.add(R.drawable.tarawa_kiribati_temple_large);
        allImageIds.add(R.drawable.port_vila_vanuatu_temple_large);
        allImageIds.add(R.drawable.lindon_utah_temple_large);
        allImageIds.add(R.drawable.greater_guatemala_city_guatemala_temple_large);
        allImageIds.add(R.drawable.sao_paulo_east_brazil_temple_large);
        allImageIds.add(R.drawable.santa_cruz_bolivia_temple_large);



        return allImageIds;
    }

    public static ArrayList<Integer> getAllTempleInfoFileIds() {

        allTempleInfoFileIds = new ArrayList<>();

        allTempleInfoFileIds.add(R.raw.kirtland_temple);
        allTempleInfoFileIds.add(R.raw.old_nauvoo_temple);
        allTempleInfoFileIds.add(R.raw.st_george_temple);
        allTempleInfoFileIds.add(R.raw.logan_temple);
        allTempleInfoFileIds.add(R.raw.manti_temple);
        allTempleInfoFileIds.add(R.raw.salt_lake_temple);
        allTempleInfoFileIds.add(R.raw.laie_hawaii_temple);
        allTempleInfoFileIds.add(R.raw.cardston_alberta_temple);
        allTempleInfoFileIds.add(R.raw.mesa_temple);
        allTempleInfoFileIds.add(R.raw.idaho_falls_temple);
        allTempleInfoFileIds.add(R.raw.bern_switzerland_temple);
        allTempleInfoFileIds.add(R.raw.los_angeles_temple);
        allTempleInfoFileIds.add(R.raw.hamilton_new_zealand_temple);
        allTempleInfoFileIds.add(R.raw.london_england_temple);
        allTempleInfoFileIds.add(R.raw.oakland_temple);
        allTempleInfoFileIds.add(R.raw.ogden_utah_temple);
        allTempleInfoFileIds.add(R.raw.provo_temple);
        allTempleInfoFileIds.add(R.raw.washington_dc_temple);
        allTempleInfoFileIds.add(R.raw.sao_paulo_brazil_temple);
        allTempleInfoFileIds.add(R.raw.tokyo_japan_temple);
        allTempleInfoFileIds.add(R.raw.seattle_temple);
        allTempleInfoFileIds.add(R.raw.jordan_river_temple);
        allTempleInfoFileIds.add(R.raw.atlanta_temple);
        allTempleInfoFileIds.add(R.raw.apia_samoa_temple);
        allTempleInfoFileIds.add(R.raw.nukualofa_tonga_temple);
        allTempleInfoFileIds.add(R.raw.santiago_chile_temple);
        allTempleInfoFileIds.add(R.raw.papeete_tahiti_temple);
        allTempleInfoFileIds.add(R.raw.mexico_city_temple);
        allTempleInfoFileIds.add(R.raw.boise_idaho_temple);
        allTempleInfoFileIds.add(R.raw.sydney_australia_temple);
        allTempleInfoFileIds.add(R.raw.manila_philippines_temple);
        allTempleInfoFileIds.add(R.raw.dallas_texas_temple);
        allTempleInfoFileIds.add(R.raw.taipei_taiwan_temple);
        allTempleInfoFileIds.add(R.raw.guatemala_lds_temple);
        allTempleInfoFileIds.add(R.raw.freiberg_germany_temple);
        allTempleInfoFileIds.add(R.raw.stockholm_sweden_lds_temple);
        allTempleInfoFileIds.add(R.raw.chicago_temple);
        allTempleInfoFileIds.add(R.raw.johannesburg_south_africa_temple);
        allTempleInfoFileIds.add(R.raw.seoul_korea_temple);
        allTempleInfoFileIds.add(R.raw.lima_peru_temple);
        allTempleInfoFileIds.add(R.raw.buenos_aires_argentina_temple);
        allTempleInfoFileIds.add(R.raw.denver_colorado_templ);
        allTempleInfoFileIds.add(R.raw.frankfurt_germany_temple);
        allTempleInfoFileIds.add(R.raw.portland_oregon_temple);
        allTempleInfoFileIds.add(R.raw.las_vegas_temple);
        allTempleInfoFileIds.add(R.raw.toronto_temple);
        allTempleInfoFileIds.add(R.raw.san_diego_california_temple);
        allTempleInfoFileIds.add(R.raw.orlando_temple);
        allTempleInfoFileIds.add(R.raw.bountiful_temple);
        allTempleInfoFileIds.add(R.raw.hong_kong_china_temple);
        allTempleInfoFileIds.add(R.raw.mount_timpanogos_utah_temple);
        allTempleInfoFileIds.add(R.raw.st_louis_temple);
        allTempleInfoFileIds.add(R.raw.vernal_temple);
        allTempleInfoFileIds.add(R.raw.preston_england_temple);
        allTempleInfoFileIds.add(R.raw.monticello_utah_temple);
        allTempleInfoFileIds.add(R.raw.anchorage_alaska_temple);
        allTempleInfoFileIds.add(R.raw.colonia_juarez_mexico_temple);
        allTempleInfoFileIds.add(R.raw.madrid_spain_temple);
        allTempleInfoFileIds.add(R.raw.bogota_colombia_temple);
        allTempleInfoFileIds.add(R.raw.guayaquil_ecuador_temple);
        allTempleInfoFileIds.add(R.raw.spokane_washington_temple);
        allTempleInfoFileIds.add(R.raw.columbus_ohio_temple);
        allTempleInfoFileIds.add(R.raw.bismark_north_dakota_temple);
        allTempleInfoFileIds.add(R.raw.columbia_temple);
        allTempleInfoFileIds.add(R.raw.detroit_temple);
        allTempleInfoFileIds.add(R.raw.halifax_nova_scotia_lds_temple);
        allTempleInfoFileIds.add(R.raw.regina_temple);
        allTempleInfoFileIds.add(R.raw.billings_montana_temple);
        allTempleInfoFileIds.add(R.raw.edmonton_alberta_temple);
        allTempleInfoFileIds.add(R.raw.raleigh_north_carolina_temple);
        allTempleInfoFileIds.add(R.raw.st_paul_temple);
        allTempleInfoFileIds.add(R.raw.kona_temple);
        allTempleInfoFileIds.add(R.raw.ciudad_juarez_mexico_temple);
        allTempleInfoFileIds.add(R.raw.hermosillo_sonora_mexico_temple);
        allTempleInfoFileIds.add(R.raw.albuquerque_temple);
        allTempleInfoFileIds.add(R.raw.oaxaca_mexico_temple);
        allTempleInfoFileIds.add(R.raw.tuxtla_guitierrez_mexico_temple);
        allTempleInfoFileIds.add(R.raw.louisville_temple);
        allTempleInfoFileIds.add(R.raw.palmyra_temple);
        allTempleInfoFileIds.add(R.raw.fresno_temple);
        allTempleInfoFileIds.add(R.raw.medford_temple);
        allTempleInfoFileIds.add(R.raw.memphis_tennessee_temple);
        allTempleInfoFileIds.add(R.raw.reno_nevada_lds_temple);
        allTempleInfoFileIds.add(R.raw.cochabamba_bolivia_temple);
        allTempleInfoFileIds.add(R.raw.tampico_mexico_temple);
        allTempleInfoFileIds.add(R.raw.nashville_temple);
        allTempleInfoFileIds.add(R.raw.villahermosa_mexico_temple);
        allTempleInfoFileIds.add(R.raw.montreal_quebec_temple);
        allTempleInfoFileIds.add(R.raw.san_jose_costa_rica_temple);
        allTempleInfoFileIds.add(R.raw.fukuoka_japan_temple);
        allTempleInfoFileIds.add(R.raw.adelaide_australia_temple);
        allTempleInfoFileIds.add(R.raw.melbourne_australia_temple);
        allTempleInfoFileIds.add(R.raw.suva_fiji_temple);
        allTempleInfoFileIds.add(R.raw.merida_mexico_temple);
        allTempleInfoFileIds.add(R.raw.veracruz_mexico_temple);
        allTempleInfoFileIds.add(R.raw.baton_rouge_louisiana_temple);
        allTempleInfoFileIds.add(R.raw.oklahoma_city_temple);
        allTempleInfoFileIds.add(R.raw.caracas_venezuela_temple);
        allTempleInfoFileIds.add(R.raw.houston_texas_temple);
        allTempleInfoFileIds.add(R.raw.birmingham_alabama_temple);
        allTempleInfoFileIds.add(R.raw.santo_domingo_dominican_republic_temple);
        allTempleInfoFileIds.add(R.raw.boston_temple);
        allTempleInfoFileIds.add(R.raw.recife_brazil_temple);
        allTempleInfoFileIds.add(R.raw.porto_alegre_brazil_temple);
        allTempleInfoFileIds.add(R.raw.montevideo_uruguay_temple);
        allTempleInfoFileIds.add(R.raw.winter_quarters_temple);
        allTempleInfoFileIds.add(R.raw.guadalajara_temple);
        allTempleInfoFileIds.add(R.raw.perth_australia_temple);
        allTempleInfoFileIds.add(R.raw.columbia_river_temple);
        allTempleInfoFileIds.add(R.raw.snowflake_temple);
        allTempleInfoFileIds.add(R.raw.lubbock_temple);
        allTempleInfoFileIds.add(R.raw.monterrey_mexico_temple);
        allTempleInfoFileIds.add(R.raw.campinas_brazil_temple);
        allTempleInfoFileIds.add(R.raw.asuncion_paraguay_temple);
        allTempleInfoFileIds.add(R.raw.nauvoo_temple);
        allTempleInfoFileIds.add(R.raw.the_hague_netherlands_temple);
        allTempleInfoFileIds.add(R.raw.brisbane_australia_temple);
        allTempleInfoFileIds.add(R.raw.redlands_temple);
        allTempleInfoFileIds.add(R.raw.accra_ghana_temple);
        allTempleInfoFileIds.add(R.raw.copenhagen_denmark_temple);
        allTempleInfoFileIds.add(R.raw.manhattan_temple);
        allTempleInfoFileIds.add(R.raw.san_antonio_temple);
        allTempleInfoFileIds.add(R.raw.aba_nigeria_temple);
        allTempleInfoFileIds.add(R.raw.newport_beach_california_temple);
        allTempleInfoFileIds.add(R.raw.sacramento_temple);
        allTempleInfoFileIds.add(R.raw.helsinki_finland_temple);
        allTempleInfoFileIds.add(R.raw.rexburg_idaho_temple);
        allTempleInfoFileIds.add(R.raw.curitiba_brazil_temple);
        allTempleInfoFileIds.add(R.raw.panama_city_temple);
        allTempleInfoFileIds.add(R.raw.twin_falls_temple);
        allTempleInfoFileIds.add(R.raw.draper_utah_temple);
        allTempleInfoFileIds.add(R.raw.oquirrh_mountain_utah_temple);
        allTempleInfoFileIds.add(R.raw.vancouver_temple);
        allTempleInfoFileIds.add(R.raw.gila_valley_temple);
        allTempleInfoFileIds.add(R.raw.cebu_philippines_temple);
        allTempleInfoFileIds.add(R.raw.kyiv_ukraine_temple);
        allTempleInfoFileIds.add(R.raw.san_salvador_el_salvador_temple);
        allTempleInfoFileIds.add(R.raw.quetzaltenango_guatemala_temple);
        allTempleInfoFileIds.add(R.raw.kansas_city_temple);
        allTempleInfoFileIds.add(R.raw.manaus_brazil_temple);
        allTempleInfoFileIds.add(R.raw.brigham_city_utah_temple);
        allTempleInfoFileIds.add(R.raw.calgary_alberta_lds_temple);
        allTempleInfoFileIds.add(R.raw.tegucigalpa_honduras_temple);
        allTempleInfoFileIds.add(R.raw.gilbert_arizona_temple);
        allTempleInfoFileIds.add(R.raw.fort_lauderdale_florida_temple);
        allTempleInfoFileIds.add(R.raw.phoenix_arizona_temple);
        allTempleInfoFileIds.add(R.raw.cordoba_argentina_temple);
        allTempleInfoFileIds.add(R.raw.payson_utah_temple);
        allTempleInfoFileIds.add(R.raw.trujillo_peru_temple);
        allTempleInfoFileIds.add(R.raw.indianapolis_indiana_temple);
        allTempleInfoFileIds.add(R.raw.tijuana_mexico_temple);
        allTempleInfoFileIds.add(R.raw.provo_city_center_temple);
        allTempleInfoFileIds.add(R.raw.sapporo_japan_temple);
        allTempleInfoFileIds.add(R.raw.philadelphia_pennsylvania_temple);
        allTempleInfoFileIds.add(R.raw.fort_collins_colorado_temple);
        allTempleInfoFileIds.add(R.raw.star_valley_wyoming_temple);
        allTempleInfoFileIds.add(R.raw.hartford_connecticut_temple);
        allTempleInfoFileIds.add(R.raw.paris_france_temple);
        allTempleInfoFileIds.add(R.raw.tucson_arizona_temple);
        allTempleInfoFileIds.add(R.raw.meridian_idaho_temple);
        allTempleInfoFileIds.add(R.raw.cedar_city_utah_temple);
        allTempleInfoFileIds.add(R.raw.concepcion_chile_temple);
        allTempleInfoFileIds.add(R.raw.barranquilla_columbia_temple);
        allTempleInfoFileIds.add(R.raw.rome_italy_temple);
        allTempleInfoFileIds.add(R.raw.kinshasa_temple);
        allTempleInfoFileIds.add(R.raw.fortaleza_brazil_temple);
        allTempleInfoFileIds.add(R.raw.haiti_temple_exterior);
        allTempleInfoFileIds.add(R.raw.lisbon_portugal_temple);
        allTempleInfoFileIds.add(R.raw.arequipa_peru_temple);
        allTempleInfoFileIds.add(R.raw.durban_south_africa_temple);

        //temples under construction

        allTempleInfoFileIds.add(R.raw.winnipeg_manitoba_temple);
        allTempleInfoFileIds.add(R.raw.rio_de_janeiro_brazil_temple);
        allTempleInfoFileIds.add(R.raw.abidjan_ivory_coast_temple);
        allTempleInfoFileIds.add(R.raw.urdaneta_philippines_temple);
        allTempleInfoFileIds.add(R.raw.bangkok_thailand_temple);
        allTempleInfoFileIds.add(R.raw.pocatello_idaho_temple);
        allTempleInfoFileIds.add(R.raw.yigo_guam_temple);
        allTempleInfoFileIds.add(R.raw.praia_cape_verde_temple);
        allTempleInfoFileIds.add(R.raw.san_juan_puerto_rico_temple);
        allTempleInfoFileIds.add(R.raw.quito_ecuador_temple);
        allTempleInfoFileIds.add(R.raw.lima_peru_los_olivos_temple);
        allTempleInfoFileIds.add(R.raw.belem_brazil_temple);
        allTempleInfoFileIds.add(R.raw.saratoga_springs_utah_temple);
        allTempleInfoFileIds.add(R.raw.puebla_mexico_temple);
        allTempleInfoFileIds.add(R.raw.richmond_virginia_temple);
        allTempleInfoFileIds.add(R.raw.layton_utah_temple);
        allTempleInfoFileIds.add(R.raw.alabang_philippines_temple);
        allTempleInfoFileIds.add(R.raw.auckland_new_zealand_temple);
        allTempleInfoFileIds.add(R.raw.feather_river_california_temple);
        allTempleInfoFileIds.add(R.raw.orem_utah_temple);
        allTempleInfoFileIds.add(R.raw.san_pedro_sula_honduras_temple);
        allTempleInfoFileIds.add(R.raw.brasilia_brazil_temple);

        //announced temples

        allTempleInfoFileIds.add(R.raw.harare_zimbabwe_temple);
        allTempleInfoFileIds.add(R.raw.nairobi_kenya_temple);
        allTempleInfoFileIds.add(R.raw.bengaluru_india_temple);
        allTempleInfoFileIds.add(R.raw.salta_argentina_temple);
        allTempleInfoFileIds.add(R.raw.managua_nicaragua_temple);
        allTempleInfoFileIds.add(R.raw.cagayan_de_oro_philippines_temple);
        allTempleInfoFileIds.add(R.raw.russia_temple);
        allTempleInfoFileIds.add(R.raw.washington_county_utah_temple);
        allTempleInfoFileIds.add(R.raw.phnom_penh_cambodia_temple);
        allTempleInfoFileIds.add(R.raw.mendoza_argentina_temple);
        allTempleInfoFileIds.add(R.raw.salvador_brazil_temple);
        allTempleInfoFileIds.add(R.raw.lagos_nigeria_temple);
        allTempleInfoFileIds.add(R.raw.davao_philippines_temple);
        allTempleInfoFileIds.add(R.raw.tooele_valley_utah_temple);
        allTempleInfoFileIds.add(R.raw.moses_lake_washington_temple);
        allTempleInfoFileIds.add(R.raw.pago_pago_american_samoa_temple);
        allTempleInfoFileIds.add(R.raw.okinawa_city_okinawa_temple);
        allTempleInfoFileIds.add(R.raw.neiafu_tonga_temple);
        allTempleInfoFileIds.add(R.raw.antofagasta_chile_temple);
        allTempleInfoFileIds.add(R.raw.budapest_hungary_temple);
        allTempleInfoFileIds.add(R.raw.mcallen_texas_temple);
        allTempleInfoFileIds.add(R.raw.taylorsville_utah_temple);
        allTempleInfoFileIds.add(R.raw.freetown_sierra_leone_temple);
        allTempleInfoFileIds.add(R.raw.port_moresby_papua_new_guinea_temple);
        allTempleInfoFileIds.add(R.raw.bentonville_arkansas_temple);
        allTempleInfoFileIds.add(R.raw.bacolod_philippines_temple);
        allTempleInfoFileIds.add(R.raw.coban_guatemala_temple);
        allTempleInfoFileIds.add(R.raw.bahia_blanca_argentina_temple);
        allTempleInfoFileIds.add(R.raw.tallahassee_florida_temple);
        allTempleInfoFileIds.add(R.raw.lubumbashi_democratic_republic_of_the_congo_temple);
        allTempleInfoFileIds.add(R.raw.pittsburgh_pennsylvania_temple);
        allTempleInfoFileIds.add(R.raw.benin_city_nigeria_temple);
        allTempleInfoFileIds.add(R.raw.syracuse_utah_temple);
        allTempleInfoFileIds.add(R.raw.dubai_united_arab_emirates_temple);

        //allTempleInfoFileIds.add(R.raw.shanghai_china_temple);


        // October 2020 announced temples
        allTempleInfoFileIds.add(R.raw.tarawa_kiribati_temple);
        allTempleInfoFileIds.add(R.raw.port_vila_vanuatu_temple);
        allTempleInfoFileIds.add(R.raw.lindon_utah_temple);
        allTempleInfoFileIds.add(R.raw.greater_guatemala_city_guatemala_temple);
        allTempleInfoFileIds.add(R.raw.sao_paulo_east_brazil_temple);
        allTempleInfoFileIds.add(R.raw.santa_cruz_bolivia_temple);



        return allTempleInfoFileIds;

    }

    }


