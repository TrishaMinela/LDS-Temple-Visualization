package com.ldstemplevirtualization;


import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


import java.util.ArrayList;

public class ImageCache {



    private static ArrayList<Bitmap> templesList;
    private static ArrayList<Integer> allImageIds;
    private static ArrayList<Integer> allTempleInfoFileIds;
    private static float screenWidth, screenHeight;

    private static Bitmap kirtland_temple, old_nauvoo_temple, st_george_temple, logan_temple, manti_temple, salt_lake_temple, laie_hawaii_temple, cardston_alberta_temple, mesa_temple, idaho_falls_temple, bern_switzerland_temple, los_angeles_temple, hamilton_new_zealand_temple, london_england_temple, oakland_temple, ogden_utah_temple, provo_temple, washington_dc_temple, sao_paulo_brazil_temple, tokyo_japan_temple, seattle_temple, jordan_river_temple, atlanta_temple, apia_samoa_temple, nukualofa_tonga_temple, santiago_chile_temple, papeete_tahiti_temple, mexico_city_temple, boise_idaho_temple, sydney_australia_temple, manila_philippines_temple, dallas_texas_temple, taipei_taiwan_temple, guatemala_lds_temple, freiberg_germany_temple, stockholm_sweden_lds_temple, chicago_temple, johannesburg_south_africa_temple, seoul_korea_temple, lima_peru_temple, buenos_aires_argentina_temple, denver_colorado_templ, frankfurt_germany_temple, portland_oregon_temple, las_vegas_temple, toronto_temple, san_diego_california_temple, orlando_temple, bountiful_temple, hong_kong_china_temple, mount_timpanogos_utah_temple, st_louis_temple, vernal_temple, preston_england_temple, monticello_utah_temple, anchorage_alaska_temple, colonia_juarez_mexico_temple, madrid_spain_temple, bogota_colombia_temple, guayaquil_ecuador_temple, spokane_washington_temple, columbus_ohio_temple, bismark_north_dakota_temple, columbia_temple, detroit_temple, halifax_nova_scotia_lds_temple, regina_temple, billings_montana_temple, edmonton_alberta_temple, raleigh_north_carolina_temple, st_paul_temple, kona_temple, ciudad_juarez_mexico_temple, hermosillo_sonora_mexico_temple, albuquerque_temple, oaxaca_mexico_temple, tuxtla_guitierrez_mexico_temple, louisville_temple, palmyra_temple, fresno_temple, medford_temple, memphis_tennessee_temple, reno_nevada_lds_temple, cochabamba_bolivia_temple, tampico_mexico_temple, nashville_temple, villahermosa_mexico_temple, montreal_quebec_temple, san_jose_costa_rica_temple, fukuoka_japan_temple, adelaide_australia_temple, melbourne_australia_temple, suva_fiji_temple, merida_mexico_temple, veracruz_mexico_temple, baton_rouge_louisiana_temple, oklahoma_city_temple, caracas_venezuela_temple, houston_texas_temple, birmingham_alabama_temple, santo_domingo_dominican_republic_temple, boston_temple, recife_brazil_temple, porto_alegre_brazil_temple, montevideo_uruguay_temple, winter_quarters_temple, guadalajara_temple, perth_australia_temple, columbia_river_temple, snowflake_temple, lubbock_temple, monterrey_mexico_temple, campinas_brazil_temple, asuncion_paraguay_temple, nauvoo_temple, the_hague_netherlands_temple, brisbane_australia_temple, redlands_temple, accra_ghana_temple, copenhagen_denmark_temple, manhattan_temple, san_antonio_temple, aba_nigeria_temple, newport_beach_california_temple, sacramento_temple, helsinki_finland_temple, rexburg_idaho_temple, curitiba_brazil_temple, panama_city_temple, twin_falls_temple, draper_utah_temple, oquirrh_mountain_utah_temple, vancouver_temple, gila_valley_temple, cebu_philippines_temple, kyiv_ukraine_temple, san_salvador_el_salvador_temple, quetzaltenango_guatemala_temple, kansas_city_temple, manaus_brazil_temple, brigham_city_utah_temple, calgary_alberta_lds_temple, tegucigalpa_honduras_temple, gilbert_arizona_temple, fort_lauderdale_florida_temple, phoenix_arizona_temple, cordoba_argentina_temple, payson_utah_temple, trujillo_peru_temple, indianapolis_indiana_temple, tijuana_mexico_temple, provo_city_center_temple, sapporo_japan_temple, philadelphia_pennsylvania_temple, fort_collins_colorado_temple, star_valley_wyoming_temple, hartford_connecticut_temple, paris_france_temple, tucson_arizona_temple, meridian_idaho_temple, cedar_city_utah_temple, concepcion_chile_temple, barranquilla_columbia_temple, rome_italy_temple, kinshasa_temple, fortaleza_brazil_temple, haiti_temple_exterior, lisbon_portugal_temple, arequipa_peru_temple, durban_south_africa_temple;

/*
            logan_temple,
            manti_temple,
            hawaii_temple,
            cardston_alberta_temple,
            idaho_falls_temple,
            bern_switzerland_temple,
            los_angeles_temple,
            london_england_temple,
            oakland_temple,
            ogden_utah_temple,
            provo_temple,
            sao_paulo_brazil_temple,
            seattle_temple,
            jordan_river_temple,
            atlanta_temple,
            apia_samoa_temple,
            nukualofa_tonga_temple,
            papeete_tahiti_temple,
            mexico_city_temple,
            santiago_chile_temple,
            boise_idaho_temple,
            sydney_australia_temple,
            manila_philippines_temple,
            dallas_texas_temple,
            taipei_taiwan_temple,
            guatemala_lds_temple,
            freiberg_germany_temple,
            stockholm_sweden_lds_temple,
            chicago_temple,
            johannesburg_south_africa_temple,
            seoul_korea_temple,
            lima_peru_temple,
            buenos_aires_argentina_temple,
            denver_colorado_templ,
            frankfurt_germany_temple,
            portland_oregon_temple,
            las_vegas_temple,
            toronto_temple,
            san_diego_california_temple,
            orlando_temple,
            bountiful_temple,
            mount_timpanogos_utah_temple,
            st_louis_temple,
            vernal_temple,
            preston_england_temple,
            monticello_utah_temple,
            anchorage_alaska_temple,
            colonia_juarez_mexico_temple,
            madrid_spain_temple,
            bogota_colombia_temple,
            guayaquil_ecuador_temple,
            spokane_washington_temple,
            columbus_ohio_temple,
            bismark_north_dakota_temple,
            columbia_temple,
            detroit_temple,
            halifax_nova_scotia_lds_temple,
            regina_temple,
            billings_montana_temple,
            edmonton_alberta_temple,
            raleigh_north_carolina_temple,
            st_paul_temple,
            kona_temple,
            ciudad_juarez_mexico_temple,
            hermosillo_sonora_mexico_temple,
            albuquerque_temple,
            oaxaca_mexico_temple,
            tuxtla_guitierrez_mexico_temple,
            louisville_temple,
            palmyra_temple,
            fresno_temple,
            medford_temple,
            memphis_tennessee_temple,
            reno_nevada_lds_temple,
            cochabamba_bolivia_temple,
            tampico_mexico_temple,
            nashville_temple,
            villahermosa_mexico_temple,
            montreal_quebec_temple,
            san_jose_costa_rica_temple,
            fukuoka_japan_temple,
            adelaide_australia_temple,
            melbourne_australia_temple,
            suva_fiji_temple,
            merida_mexico_temple,
            veracruz_mexico_temple,
            baton_rouge_louisiana_temple,
            oklahoma_city_temple,
            caracas_venezuela_temple,
            houston_texas_temple,
            birmingham_alabama_temple,
            santo_domingo_dominican_republic_temple,
            boston_temple,
            recife_brazil_temple,
            porto_alegre_brazil_temple,
            montevideo_uruguay_temple,
            winter_quarters_temple,
            guadalajara_temple,
            perth_australia_temple,
            columbia_river_temple,
            snowflake_temple,
            lubbock_temple,
            monterrey_mexico_temple,
            campinas_brazil_temple,
            asuncion_paraguay_temple,
            nauvoo_temple,
            the_hague_netherlands_temple,
            brisbane_australia_temple,
            redlands_temple,
            accra_ghana_temple,
            copenhagen_denmark_temple,
            manhattan_temple,
            san_antonio_temple,
            aba_nigeria_temple,
            newport_beach_california_temple,
            sacramento_temple,
            helsinki_finland_temple,
            rexburg_idaho_temple,
            curitiba_brazil_temple,
            panama_city_temple,
            twin_falls_temple,
            draper_utah_temple,
            oquirrh_mountain_utah_temple,
            vancouver_temple,
            gila_valley_temple,
            cebu_philippines_temple,
            kyiv_ukraine_temple,
            san_salvador_el_salvador_temple,
            quetzaltenango_guatemala_temple,
            kansas_city_temple,
            manaus_brazil_temple,
            brigham_city_utah_temple,
            calgary_alberta_lds_temple,
            tegucigalpa_honduras_temple,
            gilbert_arizona_temple,
            fort_lauderdale_florida_temple,
            phoenix_arizona_temple,
            cordoba_argentina_temple,
            payson_utah_temple,
            trujillo_peru_temple,
            indianapolis_indiana_temple,
            tijuana_mexico_temple,
            provo_city_center_temple,
            sapporo_japan_temple,
            philadelphia_pennsylvania_temple,
            fort_collins_colorado_temple,
            star_valley_wyoming_temple,
            hartford_connecticut_temple,
            paris_france_temple,
            tucson_arizona_temple,
            meridian_idaho_temple,
            cedar_city_utah_temple,
            concepcion_chile_temple,
            barranquilla_columbia_temple,
            rome_italy_temple,
            kinshasa_temple,
            fortaleza_brazil_temple,
            haiti_temple_exterior,
            lisbon_portugal_temple,
            arequipa_peru_temple,
            durban_south_africa_temple,


 */


    private static Bitmap




            aa_imnothing,
            ab_imnothing,
            ac_imnothing,
            ad_imnothing,
            ae_imnothing,
            af_imnothing,
            ag_imnothing,
            ah_imnothing,
            ai_imnothing,
            aj_imnothing,
            ak_imnothing,
            al_imnothing,
            am_imnothing,
            an_imnothing,
            ao_imnothing,
            ap_imnothing,
            aq_imnothing,
            ar_imnothing,
            as_imnothing,
            at_imnothing,
            au_imnothing,
            av_imnothing,
            aw_imnothing,
            ax_imnothing,
            ay_imnothing,
            az_imnothing,
            ba_imnothing,
            bb_imnothing,
            bc_imnothing,
            bd_imnothing,
            be_imnothing,
            bf_imnothing,
            bg_imnothing,
            bh_imnothing,
            bi_imnothing,
            bj_imnothing,
            bk_imnothing,
            bl_imnothing,
            bm_imnothing,
            bn_imnothing,
            bo_imnothing,
            bp_imnothing,
            bq_imnothing,
            br_imnothing,
            bs_imnothing,
            bt_imnothing,
            bu_imnothing,
            bv_imnothing,
            bw_imnothing,
            bx_imnothing,
            by_imnothing,
            bz_imnothing;




    private static Bitmap logo_circle;







    /*
    private static Bitmap logan_temple;
    private static Bitmap manti_temple;
    private static Bitmap hawaii_temple;
    private static Bitmap cardston_alberta_temple;
    private static Bitmap idaho_falls_temple;
    private static Bitmap bern_switzerland_temple;
    private static Bitmap los_angeles_temple;
    private static Bitmap london_england_temple;
    private static Bitmap oakland_temple;
    private static Bitmap ogden_utah_temple;
    private static Bitmap provo_temple;
    private static Bitmap sao_paulo_brazil_temple;
    private static Bitmap seattle_temple;
    private static Bitmap jordan_river_temple;
    private static Bitmap atlanta_temple;
    private static Bitmap apia_samoa_temple;
    private static Bitmap nukualofa_tonga_temple;
    private static Bitmap papeete_tahiti_temple;
    private static Bitmap mexico_city_temple;
    private static Bitmap santiago_chile_temple;
    private static Bitmap boise_idaho_temple;
    private static Bitmap sydney_australia_temple;
    private static Bitmap manila_philippines_temple;
    private static Bitmap dallas_texas_temple;
    private static Bitmap taipei_taiwan_temple;
    private static Bitmap guatemala_lds_temple;
    private static Bitmap freiberg_germany_temple;
    private static Bitmap stockholm_sweden_lds_temple;
    private static Bitmap chicago_temple;
    private static Bitmap johannesburg_south_africa_temple;
    private static Bitmap seoul_korea_temple;
    private static Bitmap lima_peru_temple;
    private static Bitmap buenos_aires_argentina_temple;
    private static Bitmap denver_colorado_templ;
    private static Bitmap frankfurt_germany_temple;
    private static Bitmap portland_oregon_temple;
    private static Bitmap las_vegas_temple;
    private static Bitmap toronto_temple;
    private static Bitmap san_diego_california_temple;
    private static Bitmap orlando_temple;
    private static Bitmap bountiful_temple;
    private static Bitmap mount_timpanogos_utah_temple;
    private static Bitmap st_louis_temple;
    private static Bitmap vernal_temple;
    private static Bitmap preston_england_temple;
    private static Bitmap monticello_utah_temple;
    private static Bitmap anchorage_alaska_temple;
    private static Bitmap colonia_juarez_mexico_temple;
    private static Bitmap madrid_spain_temple;
    private static Bitmap bogota_colombia_temple;
    private static Bitmap guayaquil_ecuador_temple;
    private static Bitmap spokane_washington_temple;
    private static Bitmap columbus_ohio_temple;
    private static Bitmap bismark_north_dakota_temple;
    private static Bitmap columbia_temple;
    private static Bitmap detroit_temple;
    private static Bitmap halifax_nova_scotia_lds_temple;
    private static Bitmap regina_temple;
    private static Bitmap billings_montana_temple;
    private static Bitmap edmonton_alberta_temple;
    private static Bitmap raleigh_north_carolina_temple;
    private static Bitmap st_paul_temple;
    private static Bitmap kona_temple;
    private static Bitmap ciudad_juarez_mexico_temple;
    private static Bitmap hermosillo_sonora_mexico_temple;
    private static Bitmap albuquerque_temple;
    private static Bitmap oaxaca_mexico_temple;
    private static Bitmap tuxtla_guitierrez_mexico_temple;
    private static Bitmap louisville_temple;
    private static Bitmap palmyra_temple;
    private static Bitmap fresno_temple;
    private static Bitmap medford_temple;
    private static Bitmap memphis_tennessee_temple;
    private static Bitmap reno_nevada_lds_temple;
    private static Bitmap cochabamba_bolivia_temple;
    private static Bitmap tampico_mexico_temple;
    private static Bitmap nashville_temple;
    private static Bitmap villahermosa_mexico_temple;
    private static Bitmap montreal_quebec_temple;
    private static Bitmap san_jose_costa_rica_temple;
    private static Bitmap fukuoka_japan_temple;
    private static Bitmap adelaide_australia_temple;
    private static Bitmap melbourne_australia_temple;
    private static Bitmap suva_fiji_temple;
    private static Bitmap merida_mexico_temple;
    private static Bitmap veracruz_mexico_temple;
    private static Bitmap baton_rouge_louisiana_temple;
    private static Bitmap oklahoma_city_temple;
    private static Bitmap caracas_venezuela_temple;
    private static Bitmap houston_texas_temple;
    private static Bitmap birmingham_alabama_temple;
    private static Bitmap santo_domingo_dominican_republic_temple;
    private static Bitmap boston_temple;
    private static Bitmap recife_brazil_temple;
    private static Bitmap porto_alegre_brazil_temple;
    private static Bitmap montevideo_uruguay_temple;
    private static Bitmap winter_quarters_temple;
    private static Bitmap guadalajara_temple;
    private static Bitmap perth_australia_temple;
    private static Bitmap columbia_river_temple;
    private static Bitmap snowflake_temple;
    private static Bitmap lubbock_temple;
    private static Bitmap monterrey_mexico_temple;
    private static Bitmap campinas_brazil_temple;
    private static Bitmap asuncion_paraguay_temple;
    private static Bitmap nauvoo_temple;
    private static Bitmap the_hague_netherlands_temple;
    private static Bitmap brisbane_australia_temple;
    private static Bitmap redlands_temple;
    private static Bitmap accra_ghana_temple;
    private static Bitmap copenhagen_denmark_temple;
    private static Bitmap manhattan_temple;
    private static Bitmap san_antonio_temple;
    private static Bitmap aba_nigeria_temple;
    private static Bitmap newport_beach_california_temple;
    private static Bitmap sacramento_temple;
    private static Bitmap helsinki_finland_temple;
    private static Bitmap rexburg_idaho_temple;
    private static Bitmap curitiba_brazil_temple;
    private static Bitmap panama_city_temple;
    private static Bitmap twin_falls_temple;
    private static Bitmap draper_utah_temple;
    private static Bitmap oquirrh_mountain_utah_temple;
    private static Bitmap vancouver_temple;
    private static Bitmap gila_valley_temple;
    private static Bitmap cebu_philippines_temple;
    private static Bitmap kyiv_ukraine_temple;
    private static Bitmap san_salvador_el_salvador_temple;
    private static Bitmap quetzaltenango_guatemala_temple;
    private static Bitmap kansas_city_temple;
    private static Bitmap manaus_brazil_temple;
    private static Bitmap brigham_city_utah_temple;
    private static Bitmap calgary_alberta_lds_temple;
    private static Bitmap tegucigalpa_honduras_temple;
    private static Bitmap gilbert_arizona_temple;
    private static Bitmap fort_lauderdale_florida_temple;
    private static Bitmap phoenix_arizona_temple;
    private static Bitmap cordoba_argentina_temple;
    private static Bitmap payson_utah_temple;
    private static Bitmap trujillo_peru_temple;
    private static Bitmap indianapolis_indiana_temple;
    private static Bitmap tijuana_mexico_temple;
    private static Bitmap provo_city_center_temple;
    private static Bitmap sapporo_japan_temple;
    private static Bitmap philadelphia_pennsylvania_temple;
    private static Bitmap fort_collins_colorado_temple;
    private static Bitmap star_valley_wyoming_temple;
    private static Bitmap hartford_connecticut_temple;
    private static Bitmap paris_france_temple;
    private static Bitmap tucson_arizona_temple;
    private static Bitmap meridian_idaho_temple;
    private static Bitmap cedar_city_utah_temple;
    private static Bitmap concepcion_chile_temple;
    private static Bitmap barranquilla_columbia_temple;
    private static Bitmap rome_italy_temple;
    private static Bitmap kinshasa_temple;
    private static Bitmap fortaleza_brazil_temple;
    private static Bitmap haiti_temple_exterior;
    private static Bitmap lisbon_portugal_temple;
    private static Bitmap arequipa_peru_temple;
    private static Bitmap durban_south_africa_temple;


    private static Bitmap aa_imnothing;
    private static Bitmap ab_imnothing;
    private static Bitmap ac_imnothing;
    private static Bitmap ad_imnothing;
    private static Bitmap ae_imnothing;
    private static Bitmap af_imnothing;
    private static Bitmap ag_imnothing;
    private static Bitmap ah_imnothing;
    private static Bitmap ai_imnothing;
    private static Bitmap aj_imnothing;
    private static Bitmap ak_imnothing;
    private static Bitmap al_imnothing;
    private static Bitmap am_imnothing;
    private static Bitmap an_imnothing;
    private static Bitmap ao_imnothing;
    private static Bitmap ap_imnothing;
    private static Bitmap aq_imnothing;
    private static Bitmap ar_imnothing;
    private static Bitmap as_imnothing;
    private static Bitmap at_imnothing;
    private static Bitmap au_imnothing;
    private static Bitmap av_imnothing;
    private static Bitmap aw_imnothing;
    private static Bitmap ax_imnothing;
    private static Bitmap ay_imnothing;
    private static Bitmap az_imnothing;
    private static Bitmap ba_imnothing;
    private static Bitmap bb_imnothing;
    private static Bitmap bc_imnothing;
    private static Bitmap bd_imnothing;
    private static Bitmap be_imnothing;
    private static Bitmap bf_imnothing;
    private static Bitmap bg_imnothing;
    private static Bitmap bh_imnothing;
    private static Bitmap bi_imnothing;
    private static Bitmap bj_imnothing;
    private static Bitmap bk_imnothing;
    private static Bitmap bl_imnothing;
    private static Bitmap bm_imnothing;
    private static Bitmap bn_imnothing;
    private static Bitmap bo_imnothing;
    private static Bitmap bp_imnothing;
    private static Bitmap bq_imnothing;
    private static Bitmap br_imnothing;
    private static Bitmap bs_imnothing;
    private static Bitmap bt_imnothing;
    private static Bitmap bu_imnothing;
    private static Bitmap bv_imnothing;
    private static Bitmap bw_imnothing;
    private static Bitmap bx_imnothing;
    private static Bitmap by_imnothing;
    private static Bitmap bz_iamnothing;
    */

    //private static Temple logo;


    public static void init(Resources res, float w2, float h) {
        float w = w2 / 2;

        logo_circle = loadAndScale(res, R.drawable.logo_circle, w);


        //logo = new Temple(logo_circle);

        kirtland_temple = loadAndScale(res, R.drawable.kirtland_temple, w);
        old_nauvoo_temple = loadAndScale(res, R.drawable.old_nauvoo_temple, w);
        st_george_temple = loadAndScale(res, R.drawable.st_george_temple, w);
        logan_temple = loadAndScale(res, R.drawable.logan_temple, w);
        manti_temple = loadAndScale(res, R.drawable.manti_temple, w);
        salt_lake_temple = loadAndScale(res, R.drawable.salt_lake_temple, w);
        laie_hawaii_temple = loadAndScale(res, R.drawable.laie_hawaii_temple, w);
        cardston_alberta_temple = loadAndScale(res, R.drawable.cardston_alberta_temple, w);
        mesa_temple = loadAndScale(res, R.drawable.mesa_temple, w);
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

        /*
        logan_temple = loadAndScale(res, R.drawable.aaa, w);
        manti_temple = loadAndScale(res, R.drawable.aab, w);
        hawaii_temple = loadAndScale(res, R.drawable.aac, w);
        cardston_alberta_temple = loadAndScale(res, R.drawable.aad, w);
        idaho_falls_temple = loadAndScale(res, R.drawable.aae, w);
        bern_switzerland_temple = loadAndScale(res, R.drawable.aaf, w);
        los_angeles_temple = loadAndScale(res, R.drawable.aag, w);
        london_england_temple = loadAndScale(res, R.drawable.aah, w);
        oakland_temple = loadAndScale(res, R.drawable.aai, w);
        ogden_utah_temple = loadAndScale(res, R.drawable.aaj, w);
        provo_temple = loadAndScale(res, R.drawable.aak, w);
        sao_paulo_brazil_temple = loadAndScale(res, R.drawable.aal, w);
        seattle_temple = loadAndScale(res, R.drawable.aam, w);
        jordan_river_temple = loadAndScale(res, R.drawable.aan, w);
        atlanta_temple = loadAndScale(res, R.drawable.aao, w);
        apia_samoa_temple = loadAndScale(res, R.drawable.aap, w);
        nukualofa_tonga_temple = loadAndScale(res, R.drawable.aaq, w);
        papeete_tahiti_temple = loadAndScale(res, R.drawable.aar, w);
        mexico_city_temple = loadAndScale(res, R.drawable.aas, w);
        santiago_chile_temple = loadAndScale(res, R.drawable.aat, w);
        boise_idaho_temple = loadAndScale(res, R.drawable.aau, w);
        sydney_australia_temple = loadAndScale(res, R.drawable.aav, w);
        manila_philippines_temple = loadAndScale(res, R.drawable.aaw, w);
        dallas_texas_temple = loadAndScale(res, R.drawable.aax, w);
        taipei_taiwan_temple = loadAndScale(res, R.drawable.aay, w);
        guatemala_lds_temple = loadAndScale(res, R.drawable.aaz, w);
        freiberg_germany_temple = loadAndScale(res, R.drawable.aaza, w);
        stockholm_sweden_lds_temple = loadAndScale(res, R.drawable.aazb, w);
        chicago_temple = loadAndScale(res, R.drawable.aazc, w);
        johannesburg_south_africa_temple = loadAndScale(res, R.drawable.aazd, w);
        seoul_korea_temple = loadAndScale(res, R.drawable.aaze, w);
        lima_peru_temple = loadAndScale(res, R.drawable.aazf, w);
        buenos_aires_argentina_temple = loadAndScale(res, R.drawable.aazg, w);
        denver_colorado_templ = loadAndScale(res, R.drawable.aazh, w);
        frankfurt_germany_temple = loadAndScale(res, R.drawable.aazi, w);
        portland_oregon_temple = loadAndScale(res, R.drawable.aazj, w);
        las_vegas_temple = loadAndScale(res, R.drawable.aazk, w);
        toronto_temple = loadAndScale(res, R.drawable.aazl, w);
        san_diego_california_temple = loadAndScale(res, R.drawable.aazm, w);
        orlando_temple = loadAndScale(res, R.drawable.aazn, w);
        bountiful_temple = loadAndScale(res, R.drawable.aazo, w);
        mount_timpanogos_utah_temple = loadAndScale(res, R.drawable.aazp, w);
        st_louis_temple = loadAndScale(res, R.drawable.aazq, w);
        vernal_temple = loadAndScale(res, R.drawable.aazr, w);
        preston_england_temple = loadAndScale(res, R.drawable.aazs, w);
        monticello_utah_temple = loadAndScale(res, R.drawable.aazt, w);
        anchorage_alaska_temple = loadAndScale(res, R.drawable.aazu, w);
        colonia_juarez_mexico_temple = loadAndScale(res, R.drawable.aazv, w);
        madrid_spain_temple = loadAndScale(res, R.drawable.aazw, w);
        bogota_colombia_temple = loadAndScale(res, R.drawable.aazx, w);
        guayaquil_ecuador_temple = loadAndScale(res, R.drawable.aazy, w);
        spokane_washington_temple = loadAndScale(res, R.drawable.aazz, w);
        columbus_ohio_temple = loadAndScale(res, R.drawable.aazza, w);
        bismark_north_dakota_temple = loadAndScale(res, R.drawable.aazzb, w);
        columbia_temple = loadAndScale(res, R.drawable.aazzc, w);
        detroit_temple = loadAndScale(res, R.drawable.aazzd, w);
        halifax_nova_scotia_lds_temple = loadAndScale(res, R.drawable.aazze, w);
        regina_temple = loadAndScale(res, R.drawable.aazzf, w);
        billings_montana_temple = loadAndScale(res, R.drawable.aazzg, w);
        edmonton_alberta_temple = loadAndScale(res, R.drawable.aazzh, w);
        raleigh_north_carolina_temple = loadAndScale(res, R.drawable.aazzi, w);
        st_paul_temple = loadAndScale(res, R.drawable.aazzj, w);
        kona_temple = loadAndScale(res, R.drawable.aazzk, w);
        ciudad_juarez_mexico_temple = loadAndScale(res, R.drawable.aazzl, w);
        hermosillo_sonora_mexico_temple = loadAndScale(res, R.drawable.aazzm, w);
        albuquerque_temple = loadAndScale(res, R.drawable.aazzn, w);
        oaxaca_mexico_temple = loadAndScale(res, R.drawable.aazzo, w);
        tuxtla_guitierrez_mexico_temple = loadAndScale(res, R.drawable.aazzp, w);
        louisville_temple = loadAndScale(res, R.drawable.aazzq, w);
        palmyra_temple = loadAndScale(res, R.drawable.aazzr, w);
        fresno_temple = loadAndScale(res, R.drawable.aazzs, w);
        medford_temple = loadAndScale(res, R.drawable.aazzt, w);
        memphis_tennessee_temple = loadAndScale(res, R.drawable.aazzu, w);
        reno_nevada_lds_temple = loadAndScale(res, R.drawable.aazzv, w);
        cochabamba_bolivia_temple = loadAndScale(res, R.drawable.aazzw, w);
        tampico_mexico_temple = loadAndScale(res, R.drawable.aazzx, w);
        nashville_temple = loadAndScale(res, R.drawable.aazzy, w);
        villahermosa_mexico_temple = loadAndScale(res, R.drawable.aazzz, w);
        montreal_quebec_temple = loadAndScale(res, R.drawable.aazzza, w);
        san_jose_costa_rica_temple = loadAndScale(res, R.drawable.aazzzb, w);
        fukuoka_japan_temple = loadAndScale(res, R.drawable.aazzzc, w);
        adelaide_australia_temple = loadAndScale(res, R.drawable.aazzzd, w);
        melbourne_australia_temple = loadAndScale(res, R.drawable.aazzze, w);
        suva_fiji_temple = loadAndScale(res, R.drawable.aazzzf, w);
        merida_mexico_temple = loadAndScale(res, R.drawable.aazzzg, w);
        veracruz_mexico_temple = loadAndScale(res, R.drawable.aazzzh, w);
        baton_rouge_louisiana_temple = loadAndScale(res, R.drawable.aazzzi, w);
        oklahoma_city_temple = loadAndScale(res, R.drawable.aazzzj, w);
        caracas_venezuela_temple = loadAndScale(res, R.drawable.aazzzk, w);
        houston_texas_temple = loadAndScale(res, R.drawable.aazzzl, w);
        birmingham_alabama_temple = loadAndScale(res, R.drawable.aazzzm, w);
        santo_domingo_dominican_republic_temple = loadAndScale(res, R.drawable.aazzzn, w);
        boston_temple = loadAndScale(res, R.drawable.aazzzo, w);
        recife_brazil_temple = loadAndScale(res, R.drawable.aazzzp, w);
        porto_alegre_brazil_temple = loadAndScale(res, R.drawable.aazzzq, w);
        montevideo_uruguay_temple = loadAndScale(res, R.drawable.aazzzr, w);
        winter_quarters_temple = loadAndScale(res, R.drawable.aazzzs, w);
        guadalajara_temple = loadAndScale(res, R.drawable.aazzzt, w);
        perth_australia_temple = loadAndScale(res, R.drawable.aazzzu, w);
        columbia_river_temple = loadAndScale(res, R.drawable.aazzzv, w);
        snowflake_temple = loadAndScale(res, R.drawable.aazzzw, w);
        lubbock_temple = loadAndScale(res, R.drawable.aazzzx, w);
        monterrey_mexico_temple = loadAndScale(res, R.drawable.aazzzy, w);
        campinas_brazil_temple = loadAndScale(res, R.drawable.aazzzz, w);
        asuncion_paraguay_temple = loadAndScale(res, R.drawable.aazzzza, w);
        nauvoo_temple = loadAndScale(res, R.drawable.aazzzzb, w);
        the_hague_netherlands_temple = loadAndScale(res, R.drawable.aazzzzc, w);
        brisbane_australia_temple = loadAndScale(res, R.drawable.aazzzzd, w);
        redlands_temple = loadAndScale(res, R.drawable.aazzzze, w);
        accra_ghana_temple = loadAndScale(res, R.drawable.aazzzzf, w);
        copenhagen_denmark_temple = loadAndScale(res, R.drawable.aazzzzg, w);
        manhattan_temple = loadAndScale(res, R.drawable.aazzzzh, w);
        san_antonio_temple = loadAndScale(res, R.drawable.aazzzzi, w);
        aba_nigeria_temple = loadAndScale(res, R.drawable.aazzzzj, w);
        newport_beach_california_temple = loadAndScale(res, R.drawable.aazzzzk, w);
        sacramento_temple = loadAndScale(res, R.drawable.aazzzzl, w);
        helsinki_finland_temple = loadAndScale(res, R.drawable.aazzzzm, w);
        rexburg_idaho_temple = loadAndScale(res, R.drawable.aazzzzn, w);
        curitiba_brazil_temple = loadAndScale(res, R.drawable.aazzzzo, w);
        panama_city_temple = loadAndScale(res, R.drawable.aazzzzp, w);
        twin_falls_temple = loadAndScale(res, R.drawable.aazzzzq, w);
        draper_utah_temple = loadAndScale(res, R.drawable.aazzzzr, w);
        oquirrh_mountain_utah_temple = loadAndScale(res, R.drawable.aazzzzs, w);
        vancouver_temple = loadAndScale(res, R.drawable.aazzzzt, w);
        gila_valley_temple = loadAndScale(res, R.drawable.aazzzzu, w);
        cebu_philippines_temple = loadAndScale(res, R.drawable.aazzzzv, w);
        kyiv_ukraine_temple = loadAndScale(res, R.drawable.aazzzzw, w);
        san_salvador_el_salvador_temple = loadAndScale(res, R.drawable.aazzzzx, w);
        quetzaltenango_guatemala_temple = loadAndScale(res, R.drawable.aazzzzy, w);
        kansas_city_temple = loadAndScale(res, R.drawable.aazzzzz, w);
        manaus_brazil_temple = loadAndScale(res, R.drawable.aazzzzza, w);
        brigham_city_utah_temple = loadAndScale(res, R.drawable.aazzzzzb, w);
        calgary_alberta_lds_temple = loadAndScale(res, R.drawable.aazzzzzc, w);
        tegucigalpa_honduras_temple = loadAndScale(res, R.drawable.aazzzzzd, w);
        gilbert_arizona_temple = loadAndScale(res, R.drawable.aazzzzze, w);
        fort_lauderdale_florida_temple = loadAndScale(res, R.drawable.aazzzzzf, w);
        phoenix_arizona_temple = loadAndScale(res, R.drawable.aazzzzzg, w);
        cordoba_argentina_temple = loadAndScale(res, R.drawable.aazzzzzh, w);
        payson_utah_temple = loadAndScale(res, R.drawable.aazzzzzi, w);
        trujillo_peru_temple = loadAndScale(res, R.drawable.aazzzzzj, w);
        indianapolis_indiana_temple = loadAndScale(res, R.drawable.aazzzzzk, w);
        tijuana_mexico_temple = loadAndScale(res, R.drawable.aazzzzzl, w);
        provo_city_center_temple = loadAndScale(res, R.drawable.aazzzzzm, w);
        sapporo_japan_temple = loadAndScale(res, R.drawable.aazzzzzn, w);
        philadelphia_pennsylvania_temple = loadAndScale(res, R.drawable.aazzzzzo, w);
        fort_collins_colorado_temple = loadAndScale(res, R.drawable.aazzzzzp, w);
        star_valley_wyoming_temple = loadAndScale(res, R.drawable.aazzzzzq, w);
        hartford_connecticut_temple = loadAndScale(res, R.drawable.aazzzzzr, w);
        paris_france_temple = loadAndScale(res, R.drawable.aazzzzzs, w);
        tucson_arizona_temple = loadAndScale(res, R.drawable.aazzzzzt, w);
        meridian_idaho_temple = loadAndScale(res, R.drawable.aazzzzzu, w);
        cedar_city_utah_temple = loadAndScale(res, R.drawable.aazzzzzv, w);
        concepcion_chile_temple = loadAndScale(res, R.drawable.aazzzzzw, w);
        barranquilla_columbia_temple = loadAndScale(res, R.drawable.aazzzzzx, w);
        rome_italy_temple = loadAndScale(res, R.drawable.aazzzzzy, w);
        kinshasa_temple = loadAndScale(res, R.drawable.aazzzzzz, w);
        fortaleza_brazil_temple = loadAndScale(res, R.drawable.aazzzzzza, w);
        haiti_temple_exterior = loadAndScale(res, R.drawable.aazzzzzzb, w);
        lisbon_portugal_temple = loadAndScale(res, R.drawable.aazzzzzzc, w);
        arequipa_peru_temple = loadAndScale(res, R.drawable.aazzzzzzd, w);
        durban_south_africa_temple = loadAndScale(res, R.drawable.aazzzzzze, w);


         */





        aa_imnothing = loadAndScale(res, R.drawable.aa_imnothing, w);
        ab_imnothing = loadAndScale(res, R.drawable.ab_imnothing, w);
        ac_imnothing = loadAndScale(res, R.drawable.ac_imnothing, w);
        ad_imnothing = loadAndScale(res, R.drawable.ad_imnothing, w);
        ae_imnothing = loadAndScale(res, R.drawable.ae_imnothing, w);
        af_imnothing = loadAndScale(res, R.drawable.af_imnothing, w);
        ag_imnothing = loadAndScale(res, R.drawable.ag_imnothing, w);
        ah_imnothing = loadAndScale(res, R.drawable.ah_imnothing, w);
        ai_imnothing = loadAndScale(res, R.drawable.ai_imnothing, w);
        aj_imnothing = loadAndScale(res, R.drawable.aj_imnothing, w);
        ak_imnothing = loadAndScale(res, R.drawable.ak_imnothing, w);
        al_imnothing = loadAndScale(res, R.drawable.al_imnothing, w);
        am_imnothing = loadAndScale(res, R.drawable.am_imnothing, w);
        an_imnothing = loadAndScale(res, R.drawable.an_imnothing, w);
        ao_imnothing = loadAndScale(res, R.drawable.ao_imnothing, w);
        ap_imnothing = loadAndScale(res, R.drawable.ap_imnothing, w);
        aq_imnothing = loadAndScale(res, R.drawable.aq_imnothing, w);
        ar_imnothing = loadAndScale(res, R.drawable.ar_imnothing, w);
        as_imnothing = loadAndScale(res, R.drawable.as_imnothing, w);
        at_imnothing = loadAndScale(res, R.drawable.at_imnothing, w);
        au_imnothing = loadAndScale(res, R.drawable.au_imnothing, w);
        av_imnothing = loadAndScale(res, R.drawable.av_imnothing, w);
        aw_imnothing = loadAndScale(res, R.drawable.aw_imnothing, w);
        ax_imnothing = loadAndScale(res, R.drawable.ax_imnothing, w);
        ay_imnothing = loadAndScale(res, R.drawable.ay_imnothing, w);
        az_imnothing = loadAndScale(res, R.drawable.az_imnothing, w);
        ba_imnothing = loadAndScale(res, R.drawable.ba_imnothing, w);
        bb_imnothing = loadAndScale(res, R.drawable.bb_imnothing, w);
        bc_imnothing = loadAndScale(res, R.drawable.bc_imnothing, w);
        bd_imnothing = loadAndScale(res, R.drawable.bd_imnothing, w);
        be_imnothing = loadAndScale(res, R.drawable.be_imnothing, w);
        bf_imnothing = loadAndScale(res, R.drawable.bf_imnothing, w);
        bg_imnothing = loadAndScale(res, R.drawable.bg_imnothing, w);
        bh_imnothing = loadAndScale(res, R.drawable.bh_imnothing, w);
        bi_imnothing = loadAndScale(res, R.drawable.bi_imnothing, w);
        bj_imnothing = loadAndScale(res, R.drawable.bj_imnothing, w);
        bk_imnothing = loadAndScale(res, R.drawable.bk_imnothing, w);
        bl_imnothing = loadAndScale(res, R.drawable.bl_imnothing, w);
        bm_imnothing = loadAndScale(res, R.drawable.bm_imnothing, w);
        bn_imnothing = loadAndScale(res, R.drawable.bn_imnothing, w);
        bo_imnothing = loadAndScale(res, R.drawable.bo_imnothing, w);
        bp_imnothing = loadAndScale(res, R.drawable.bp_imnothing, w);
        bq_imnothing = loadAndScale(res, R.drawable.bq_imnothing, w);
        br_imnothing = loadAndScale(res, R.drawable.br_imnothing, w);
        bs_imnothing = loadAndScale(res, R.drawable.bs_imnothing, w);
        bt_imnothing = loadAndScale(res, R.drawable.bt_imnothing, w);
        bu_imnothing = loadAndScale(res, R.drawable.bu_imnothing, w);
        bv_imnothing = loadAndScale(res, R.drawable.bv_imnothing, w);
        bw_imnothing = loadAndScale(res, R.drawable.bw_imnothing, w);
        bx_imnothing = loadAndScale(res, R.drawable.bx_imnothing, w);
        by_imnothing = loadAndScale(res, R.drawable.by_imnothing, w);
        bz_imnothing = loadAndScale(res, R.drawable.bz_imnothing, w);


    }


    private static Bitmap loadAndScale(Resources res, int id, float newWidth) {
        Bitmap original = BitmapFactory.decodeResource(res, id);
        float aspectRatio = (float)original.getHeight()/(float)original.getWidth();
        float newHeight = newWidth * aspectRatio;
        return Bitmap.createScaledBitmap(original, (int)newWidth, (int)newHeight, true);
    }



    public static ArrayList<Bitmap> getTemplesList() {
        templesList = new ArrayList<>();


        templesList.add(kirtland_temple);
        templesList.add(old_nauvoo_temple);
        templesList.add(st_george_temple);
        templesList.add(logan_temple);
        templesList.add(manti_temple);
        templesList.add(salt_lake_temple);
        templesList.add(laie_hawaii_temple);
        templesList.add(cardston_alberta_temple);
        templesList.add(mesa_temple);
        templesList.add(idaho_falls_temple);
        templesList.add(bern_switzerland_temple);
        templesList.add(los_angeles_temple);
        templesList.add(hamilton_new_zealand_temple);
        templesList.add(london_england_temple);
        templesList.add(oakland_temple);
        templesList.add(ogden_utah_temple);
        templesList.add(provo_temple);
        templesList.add(washington_dc_temple);
        templesList.add(sao_paulo_brazil_temple);
        templesList.add(tokyo_japan_temple);
        templesList.add(seattle_temple);
        templesList.add(jordan_river_temple);
        templesList.add(atlanta_temple);
        templesList.add(apia_samoa_temple);
        templesList.add(nukualofa_tonga_temple);
        templesList.add(santiago_chile_temple);
        templesList.add(papeete_tahiti_temple);
        templesList.add(mexico_city_temple);
        templesList.add(boise_idaho_temple);
        templesList.add(sydney_australia_temple);
        templesList.add(manila_philippines_temple);
        templesList.add(dallas_texas_temple);
        templesList.add(taipei_taiwan_temple);
        templesList.add(guatemala_lds_temple);
        templesList.add(freiberg_germany_temple);
        templesList.add(stockholm_sweden_lds_temple);
        templesList.add(chicago_temple);
        templesList.add(johannesburg_south_africa_temple);
        templesList.add(seoul_korea_temple);
        templesList.add(lima_peru_temple);
        templesList.add(buenos_aires_argentina_temple);
        templesList.add(denver_colorado_templ);
        templesList.add(frankfurt_germany_temple);
        templesList.add(portland_oregon_temple);
        templesList.add(las_vegas_temple);
        templesList.add(toronto_temple);
        templesList.add(san_diego_california_temple);
        templesList.add(orlando_temple);
        templesList.add(bountiful_temple);
        templesList.add(hong_kong_china_temple);
        templesList.add(mount_timpanogos_utah_temple);
        templesList.add(st_louis_temple);
        templesList.add(vernal_temple);
        templesList.add(preston_england_temple);
        templesList.add(monticello_utah_temple);
        templesList.add(anchorage_alaska_temple);
        templesList.add(colonia_juarez_mexico_temple);
        templesList.add(madrid_spain_temple);
        templesList.add(bogota_colombia_temple);
        templesList.add(guayaquil_ecuador_temple);
        templesList.add(spokane_washington_temple);
        templesList.add(columbus_ohio_temple);
        templesList.add(bismark_north_dakota_temple);
        templesList.add(columbia_temple);
        templesList.add(detroit_temple);
        templesList.add(halifax_nova_scotia_lds_temple);
        templesList.add(regina_temple);
        templesList.add(billings_montana_temple);
        templesList.add(edmonton_alberta_temple);
        templesList.add(raleigh_north_carolina_temple);
        templesList.add(st_paul_temple);
        templesList.add(kona_temple);
        templesList.add(ciudad_juarez_mexico_temple);
        templesList.add(hermosillo_sonora_mexico_temple);
        templesList.add(albuquerque_temple);
        templesList.add(oaxaca_mexico_temple);
        templesList.add(tuxtla_guitierrez_mexico_temple);
        templesList.add(louisville_temple);
        templesList.add(palmyra_temple);
        templesList.add(fresno_temple);
        templesList.add(medford_temple);
        templesList.add(memphis_tennessee_temple);
        templesList.add(reno_nevada_lds_temple);
        templesList.add(cochabamba_bolivia_temple);
        templesList.add(tampico_mexico_temple);
        templesList.add(nashville_temple);
        templesList.add(villahermosa_mexico_temple);
        templesList.add(montreal_quebec_temple);
        templesList.add(san_jose_costa_rica_temple);
        templesList.add(fukuoka_japan_temple);
        templesList.add(adelaide_australia_temple);
        templesList.add(melbourne_australia_temple);
        templesList.add(suva_fiji_temple);
        templesList.add(merida_mexico_temple);
        templesList.add(veracruz_mexico_temple);
        templesList.add(baton_rouge_louisiana_temple);
        templesList.add(oklahoma_city_temple);
        templesList.add(caracas_venezuela_temple);
        templesList.add(houston_texas_temple);
        templesList.add(birmingham_alabama_temple);
        templesList.add(santo_domingo_dominican_republic_temple);
        templesList.add(boston_temple);
        templesList.add(recife_brazil_temple);
        templesList.add(porto_alegre_brazil_temple);
        templesList.add(montevideo_uruguay_temple);
        templesList.add(winter_quarters_temple);
        templesList.add(guadalajara_temple);
        templesList.add(perth_australia_temple);
        templesList.add(columbia_river_temple);
        templesList.add(snowflake_temple);
        templesList.add(lubbock_temple);
        templesList.add(monterrey_mexico_temple);
        templesList.add(campinas_brazil_temple);
        templesList.add(asuncion_paraguay_temple);
        templesList.add(nauvoo_temple);
        templesList.add(the_hague_netherlands_temple);
        templesList.add(brisbane_australia_temple);
        templesList.add(redlands_temple);
        templesList.add(accra_ghana_temple);
        templesList.add(copenhagen_denmark_temple);
        templesList.add(manhattan_temple);
        templesList.add(san_antonio_temple);
        templesList.add(aba_nigeria_temple);
        templesList.add(newport_beach_california_temple);
        templesList.add(sacramento_temple);
        templesList.add(helsinki_finland_temple);
        templesList.add(rexburg_idaho_temple);
        templesList.add(curitiba_brazil_temple);
        templesList.add(panama_city_temple);
        templesList.add(twin_falls_temple);
        templesList.add(draper_utah_temple);
        templesList.add(oquirrh_mountain_utah_temple);
        templesList.add(vancouver_temple);
        templesList.add(gila_valley_temple);
        templesList.add(cebu_philippines_temple);
        templesList.add(kyiv_ukraine_temple);
        templesList.add(san_salvador_el_salvador_temple);
        templesList.add(quetzaltenango_guatemala_temple);
        templesList.add(kansas_city_temple);
        templesList.add(manaus_brazil_temple);
        templesList.add(brigham_city_utah_temple);
        templesList.add(calgary_alberta_lds_temple);
        templesList.add(tegucigalpa_honduras_temple);
        templesList.add(gilbert_arizona_temple);
        templesList.add(fort_lauderdale_florida_temple);
        templesList.add(phoenix_arizona_temple);
        templesList.add(cordoba_argentina_temple);
        templesList.add(payson_utah_temple);
        templesList.add(trujillo_peru_temple);
        templesList.add(indianapolis_indiana_temple);
        templesList.add(tijuana_mexico_temple);
        templesList.add(provo_city_center_temple);
        templesList.add(sapporo_japan_temple);
        templesList.add(philadelphia_pennsylvania_temple);
        templesList.add(fort_collins_colorado_temple);
        templesList.add(star_valley_wyoming_temple);
        templesList.add(hartford_connecticut_temple);
        templesList.add(paris_france_temple);
        templesList.add(tucson_arizona_temple);
        templesList.add(meridian_idaho_temple);
        templesList.add(cedar_city_utah_temple);
        templesList.add(concepcion_chile_temple);
        templesList.add(barranquilla_columbia_temple);
        templesList.add(rome_italy_temple);
        templesList.add(kinshasa_temple);
        templesList.add(fortaleza_brazil_temple);
        templesList.add(haiti_temple_exterior);
        templesList.add(lisbon_portugal_temple);
        templesList.add(arequipa_peru_temple);
        templesList.add(durban_south_africa_temple);

        /*
        templesList.add(logan_temple);
        templesList.add(manti_temple);
        templesList.add(hawaii_temple);
        templesList.add(cardston_alberta_temple);
        templesList.add(idaho_falls_temple);
        templesList.add(bern_switzerland_temple);
        templesList.add(los_angeles_temple);
        templesList.add(london_england_temple);
        templesList.add(oakland_temple);
        templesList.add(ogden_utah_temple);
        templesList.add(provo_temple);
        templesList.add(sao_paulo_brazil_temple);
        templesList.add(seattle_temple);
        templesList.add(jordan_river_temple);
        templesList.add(atlanta_temple);
        templesList.add(apia_samoa_temple);
        templesList.add(nukualofa_tonga_temple);
        templesList.add(papeete_tahiti_temple);
        templesList.add(mexico_city_temple);
        templesList.add(santiago_chile_temple);
        templesList.add(boise_idaho_temple);
        templesList.add(sydney_australia_temple);
        templesList.add(manila_philippines_temple);
        templesList.add(dallas_texas_temple);
        templesList.add(taipei_taiwan_temple);
        templesList.add(guatemala_lds_temple);
        templesList.add(freiberg_germany_temple);
        templesList.add(stockholm_sweden_lds_temple);
        templesList.add(chicago_temple);
        templesList.add(johannesburg_south_africa_temple);
        templesList.add(seoul_korea_temple);
        templesList.add(lima_peru_temple);
        templesList.add(buenos_aires_argentina_temple);
        templesList.add(denver_colorado_templ);
        templesList.add(frankfurt_germany_temple);
        templesList.add(portland_oregon_temple);
        templesList.add(las_vegas_temple);
        templesList.add(toronto_temple);
        templesList.add(san_diego_california_temple);
        templesList.add(orlando_temple);
        templesList.add(bountiful_temple);
        templesList.add(mount_timpanogos_utah_temple);
        templesList.add(st_louis_temple);
        templesList.add(vernal_temple);
        templesList.add(preston_england_temple);
        templesList.add(monticello_utah_temple);
        templesList.add(anchorage_alaska_temple);
        templesList.add(colonia_juarez_mexico_temple);
        templesList.add(madrid_spain_temple);
        templesList.add(bogota_colombia_temple);
        templesList.add(guayaquil_ecuador_temple);
        templesList.add(spokane_washington_temple);
        templesList.add(columbus_ohio_temple);
        templesList.add(bismark_north_dakota_temple);
        templesList.add(columbia_temple);
        templesList.add(detroit_temple);
        templesList.add(halifax_nova_scotia_lds_temple);
        templesList.add(regina_temple);
        templesList.add(billings_montana_temple);
        templesList.add(edmonton_alberta_temple);
        templesList.add(raleigh_north_carolina_temple);
        templesList.add(st_paul_temple);
        templesList.add(kona_temple);
        templesList.add(ciudad_juarez_mexico_temple);
        templesList.add(hermosillo_sonora_mexico_temple);
        templesList.add(albuquerque_temple);
        templesList.add(oaxaca_mexico_temple);
        templesList.add(tuxtla_guitierrez_mexico_temple);
        templesList.add(louisville_temple);
        templesList.add(palmyra_temple);
        templesList.add(fresno_temple);
        templesList.add(medford_temple);
        templesList.add(memphis_tennessee_temple);
        templesList.add(reno_nevada_lds_temple);
        templesList.add(cochabamba_bolivia_temple);
        templesList.add(tampico_mexico_temple);
        templesList.add(nashville_temple);
        templesList.add(villahermosa_mexico_temple);
        templesList.add(montreal_quebec_temple);
        templesList.add(san_jose_costa_rica_temple);
        templesList.add(fukuoka_japan_temple);
        templesList.add(adelaide_australia_temple);
        templesList.add(melbourne_australia_temple);
        templesList.add(suva_fiji_temple);
        templesList.add(merida_mexico_temple);
        templesList.add(veracruz_mexico_temple);
        templesList.add(baton_rouge_louisiana_temple);
        templesList.add(oklahoma_city_temple);
        templesList.add(caracas_venezuela_temple);
        templesList.add(houston_texas_temple);
        templesList.add(birmingham_alabama_temple);
        templesList.add(santo_domingo_dominican_republic_temple);
        templesList.add(boston_temple);
        templesList.add(recife_brazil_temple);
        templesList.add(porto_alegre_brazil_temple);
        templesList.add(montevideo_uruguay_temple);
        templesList.add(winter_quarters_temple);
        templesList.add(guadalajara_temple);
        templesList.add(perth_australia_temple);
        templesList.add(columbia_river_temple);
        templesList.add(snowflake_temple);
        templesList.add(lubbock_temple);
        templesList.add(monterrey_mexico_temple);
        templesList.add(campinas_brazil_temple);
        templesList.add(asuncion_paraguay_temple);
        templesList.add(nauvoo_temple);
        templesList.add(the_hague_netherlands_temple);
        templesList.add(brisbane_australia_temple);
        templesList.add(redlands_temple);
        templesList.add(accra_ghana_temple);
        templesList.add(copenhagen_denmark_temple);
        templesList.add(manhattan_temple);
        templesList.add(san_antonio_temple);
        templesList.add(aba_nigeria_temple);
        templesList.add(newport_beach_california_temple);
        templesList.add(sacramento_temple);
        templesList.add(helsinki_finland_temple);
        templesList.add(rexburg_idaho_temple);
        templesList.add(curitiba_brazil_temple);
        templesList.add(panama_city_temple);
        templesList.add(twin_falls_temple);
        templesList.add(draper_utah_temple);
        templesList.add(oquirrh_mountain_utah_temple);
        templesList.add(vancouver_temple);
        templesList.add(gila_valley_temple);
        templesList.add(cebu_philippines_temple);
        templesList.add(kyiv_ukraine_temple);
        templesList.add(san_salvador_el_salvador_temple);
        templesList.add(quetzaltenango_guatemala_temple);
        templesList.add(kansas_city_temple);
        templesList.add(manaus_brazil_temple);
        templesList.add(brigham_city_utah_temple);
        templesList.add(calgary_alberta_lds_temple);
        templesList.add(tegucigalpa_honduras_temple);
        templesList.add(gilbert_arizona_temple);
        templesList.add(fort_lauderdale_florida_temple);
        templesList.add(phoenix_arizona_temple);
        templesList.add(cordoba_argentina_temple);
        templesList.add(payson_utah_temple);
        templesList.add(trujillo_peru_temple);
        templesList.add(indianapolis_indiana_temple);
        templesList.add(tijuana_mexico_temple);
        templesList.add(provo_city_center_temple);
        templesList.add(sapporo_japan_temple);
        templesList.add(philadelphia_pennsylvania_temple);
        templesList.add(fort_collins_colorado_temple);
        templesList.add(star_valley_wyoming_temple);
        templesList.add(hartford_connecticut_temple);
        templesList.add(paris_france_temple);
        templesList.add(tucson_arizona_temple);
        templesList.add(meridian_idaho_temple);
        templesList.add(cedar_city_utah_temple);
        templesList.add(concepcion_chile_temple);
        templesList.add(barranquilla_columbia_temple);
        templesList.add(rome_italy_temple);
        templesList.add(kinshasa_temple);
        templesList.add(fortaleza_brazil_temple);
        templesList.add(haiti_temple_exterior);
        templesList.add(lisbon_portugal_temple);
        templesList.add(arequipa_peru_temple);
        templesList.add(durban_south_africa_temple);


         */

        templesList.add(aa_imnothing);
        templesList.add(ab_imnothing);
        templesList.add(ac_imnothing);
        templesList.add(ad_imnothing);
        templesList.add(ae_imnothing);
        templesList.add(af_imnothing);
        templesList.add(ag_imnothing);
        templesList.add(ah_imnothing);
        templesList.add(ai_imnothing);
        templesList.add(aj_imnothing);
        templesList.add(ak_imnothing);
        templesList.add(al_imnothing);
        templesList.add(am_imnothing);
        templesList.add(an_imnothing);
        templesList.add(ao_imnothing);
        templesList.add(ap_imnothing);
        templesList.add(aq_imnothing);
        templesList.add(ar_imnothing);
        templesList.add(as_imnothing);
        templesList.add(at_imnothing);
        templesList.add(au_imnothing);
        templesList.add(av_imnothing);
        templesList.add(aw_imnothing);
        templesList.add(ax_imnothing);
        templesList.add(ay_imnothing);
        templesList.add(az_imnothing);
        templesList.add(ba_imnothing);
        templesList.add(bb_imnothing);
        templesList.add(bc_imnothing);
        templesList.add(bd_imnothing);
        templesList.add(be_imnothing);
        templesList.add(bf_imnothing);
        templesList.add(bg_imnothing);
        templesList.add(bh_imnothing);
        templesList.add(bi_imnothing);
        templesList.add(bj_imnothing);
        templesList.add(bk_imnothing);
        templesList.add(bl_imnothing);
        templesList.add(bm_imnothing);
        templesList.add(bn_imnothing);
        templesList.add(bo_imnothing);
        templesList.add(bp_imnothing);
        templesList.add(bq_imnothing);
        templesList.add(br_imnothing);
        templesList.add(bs_imnothing);
        templesList.add(bt_imnothing);
        templesList.add(bu_imnothing);
        templesList.add(bv_imnothing);
        templesList.add(bw_imnothing);
        templesList.add(bx_imnothing);
        templesList.add(by_imnothing);
        templesList.add(bz_imnothing);






        return templesList;
    }

    public static Bitmap getLogo() {
        return logo_circle;
    }


    public static ArrayList<Integer> getAllImageIds() {

        allImageIds = new ArrayList<>();

        allImageIds.add(R.drawable.kirtland_temple_large);
        allImageIds.add(R.drawable.old_nauvoo_temple_large);
        allImageIds.add(R.drawable.st_george_temple_large);
        allImageIds.add(R.drawable.logan_temple_large);
        allImageIds.add(R.drawable.manti_temple_large);
        allImageIds.add(R.drawable.salt_lake_temple_large);
        allImageIds.add(R.drawable.laie_hawaii_temple_large);
        allImageIds.add(R.drawable.cardston_alberta_temple_large);
        allImageIds.add(R.drawable.mesa_temple_large);
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

        /*

        allImageIds.add(R.drawable.aaa_large);
        allImageIds.add(R.drawable.aab_large);
        allImageIds.add(R.drawable.aac_large);
        allImageIds.add(R.drawable.aad_large);
        allImageIds.add(R.drawable.aae_large);
        allImageIds.add(R.drawable.aaf_large);
        allImageIds.add(R.drawable.aag_large);
        allImageIds.add(R.drawable.aah_large);
        allImageIds.add(R.drawable.aai_large);
        allImageIds.add(R.drawable.aaj_large);
        allImageIds.add(R.drawable.aak_large);
        allImageIds.add(R.drawable.aal_large);
        allImageIds.add(R.drawable.aam_large);
        allImageIds.add(R.drawable.aan_large);
        allImageIds.add(R.drawable.aao_large);
        allImageIds.add(R.drawable.aap_large);
        allImageIds.add(R.drawable.aaq_large);
        allImageIds.add(R.drawable.aar_large);
        allImageIds.add(R.drawable.aas_large);
        allImageIds.add(R.drawable.aat_large);
        allImageIds.add(R.drawable.aau_large);
        allImageIds.add(R.drawable.aav_large);
        allImageIds.add(R.drawable.aaw_large);
        allImageIds.add(R.drawable.aax_large);
        allImageIds.add(R.drawable.aay_large);
        allImageIds.add(R.drawable.aaz_large);
        allImageIds.add(R.drawable.aaza_large);
        allImageIds.add(R.drawable.aazb_large);
        allImageIds.add(R.drawable.aazc_large);
        allImageIds.add(R.drawable.aazd_large);
        allImageIds.add(R.drawable.aaze_large);
        allImageIds.add(R.drawable.aazf_large);
        allImageIds.add(R.drawable.aazg_large);
        allImageIds.add(R.drawable.aazh_large);
        allImageIds.add(R.drawable.aazi_large);
        allImageIds.add(R.drawable.aazj_large);
        allImageIds.add(R.drawable.aazk_large);
        allImageIds.add(R.drawable.aazl_large);
        allImageIds.add(R.drawable.aazm_large);
        allImageIds.add(R.drawable.aazn_large);
        allImageIds.add(R.drawable.aazo_large);
        allImageIds.add(R.drawable.aazp_large);
        allImageIds.add(R.drawable.aazq_large);
        allImageIds.add(R.drawable.aazr_large);
        allImageIds.add(R.drawable.aazs_large);
        allImageIds.add(R.drawable.aazt_large);
        allImageIds.add(R.drawable.aazu_large);
        allImageIds.add(R.drawable.aazv_large);
        allImageIds.add(R.drawable.aazw_large);
        allImageIds.add(R.drawable.aazx_large);
        allImageIds.add(R.drawable.aazy_large);
        allImageIds.add(R.drawable.aazz_large);
        allImageIds.add(R.drawable.aazza_large);
        allImageIds.add(R.drawable.aazzb_large);
        allImageIds.add(R.drawable.aazzc_large);
        allImageIds.add(R.drawable.aazzd_large);
        allImageIds.add(R.drawable.aazze_large);
        allImageIds.add(R.drawable.aazzf_large);
        allImageIds.add(R.drawable.aazzg_large);
        allImageIds.add(R.drawable.aazzh_large);
        allImageIds.add(R.drawable.aazzi_large);
        allImageIds.add(R.drawable.aazzj_large);
        allImageIds.add(R.drawable.aazzk_large);
        allImageIds.add(R.drawable.aazzl_large);
        allImageIds.add(R.drawable.aazzm_large);
        allImageIds.add(R.drawable.aazzn_large);
        allImageIds.add(R.drawable.aazzo_large);
        allImageIds.add(R.drawable.aazzp_large);
        allImageIds.add(R.drawable.aazzq_large);
        allImageIds.add(R.drawable.aazzr_large);
        allImageIds.add(R.drawable.aazzs_large);
        allImageIds.add(R.drawable.aazzt_large);
        allImageIds.add(R.drawable.aazzu_large);
        allImageIds.add(R.drawable.aazzv_large);
        allImageIds.add(R.drawable.aazzw_large);
        allImageIds.add(R.drawable.aazzx_large);
        allImageIds.add(R.drawable.aazzy_large);
        allImageIds.add(R.drawable.aazzz_large);
        allImageIds.add(R.drawable.aazzza_large);
        allImageIds.add(R.drawable.aazzzb_large);
        allImageIds.add(R.drawable.aazzzc_large);
        allImageIds.add(R.drawable.aazzzd_large);
        allImageIds.add(R.drawable.aazzze_large);
        allImageIds.add(R.drawable.aazzzf_large);
        allImageIds.add(R.drawable.aazzzg_large);
        allImageIds.add(R.drawable.aazzzh_large);
        allImageIds.add(R.drawable.aazzzi_large);
        allImageIds.add(R.drawable.aazzzj_large);
        allImageIds.add(R.drawable.aazzzk_large);
        allImageIds.add(R.drawable.aazzzl_large);
        allImageIds.add(R.drawable.aazzzm_large);
        allImageIds.add(R.drawable.aazzzn_large);
        allImageIds.add(R.drawable.aazzzo_large);
        allImageIds.add(R.drawable.aazzzp_large);
        allImageIds.add(R.drawable.aazzzq_large);
        allImageIds.add(R.drawable.aazzzr_large);
        allImageIds.add(R.drawable.aazzzs_large);
        allImageIds.add(R.drawable.aazzzt_large);
        allImageIds.add(R.drawable.aazzzu_large);
        allImageIds.add(R.drawable.aazzzv_large);
        allImageIds.add(R.drawable.aazzzw_large);
        allImageIds.add(R.drawable.aazzzx_large);
        allImageIds.add(R.drawable.aazzzy_large);
        allImageIds.add(R.drawable.aazzzz_large);
        allImageIds.add(R.drawable.aazzzza_large);
        allImageIds.add(R.drawable.aazzzzb_large);
        allImageIds.add(R.drawable.aazzzzc_large);
        allImageIds.add(R.drawable.aazzzzd_large);
        allImageIds.add(R.drawable.aazzzze_large);
        allImageIds.add(R.drawable.aazzzzf_large);
        allImageIds.add(R.drawable.aazzzzg_large);
        allImageIds.add(R.drawable.aazzzzh_large);
        allImageIds.add(R.drawable.aazzzzi_large);
        allImageIds.add(R.drawable.aazzzzj_large);
        allImageIds.add(R.drawable.aazzzzk_large);
        allImageIds.add(R.drawable.aazzzzl_large);
        allImageIds.add(R.drawable.aazzzzm_large);
        allImageIds.add(R.drawable.aazzzzn_large);
        allImageIds.add(R.drawable.aazzzzo_large);
        allImageIds.add(R.drawable.aazzzzp_large);
        allImageIds.add(R.drawable.aazzzzq_large);
        allImageIds.add(R.drawable.aazzzzr_large);
        allImageIds.add(R.drawable.aazzzzs_large);
        allImageIds.add(R.drawable.aazzzzt_large);
        allImageIds.add(R.drawable.aazzzzu_large);
        allImageIds.add(R.drawable.aazzzzv_large);
        allImageIds.add(R.drawable.aazzzzw_large);
        allImageIds.add(R.drawable.aazzzzx_large);
        allImageIds.add(R.drawable.aazzzzy_large);
        allImageIds.add(R.drawable.aazzzzz_large);
        allImageIds.add(R.drawable.aazzzzza_large);
        allImageIds.add(R.drawable.aazzzzzb_large);
        allImageIds.add(R.drawable.aazzzzzc_large);
        allImageIds.add(R.drawable.aazzzzzd_large);
        allImageIds.add(R.drawable.aazzzzze_large);
        allImageIds.add(R.drawable.aazzzzzf_large);
        allImageIds.add(R.drawable.aazzzzzg_large);
        allImageIds.add(R.drawable.aazzzzzh_large);
        allImageIds.add(R.drawable.aazzzzzi_large);
        allImageIds.add(R.drawable.aazzzzzj_large);
        allImageIds.add(R.drawable.aazzzzzk_large);
        allImageIds.add(R.drawable.aazzzzzl_large);
        allImageIds.add(R.drawable.aazzzzzm_large);
        allImageIds.add(R.drawable.aazzzzzn_large);
        allImageIds.add(R.drawable.aazzzzzo_large);
        allImageIds.add(R.drawable.aazzzzzp_large);
        allImageIds.add(R.drawable.aazzzzzq_large);
        allImageIds.add(R.drawable.aazzzzzr_large);
        allImageIds.add(R.drawable.aazzzzzs_large);
        allImageIds.add(R.drawable.aazzzzzt_large);
        allImageIds.add(R.drawable.aazzzzzu_large);
        allImageIds.add(R.drawable.aazzzzzv_large);
        allImageIds.add(R.drawable.aazzzzzw_large);
        allImageIds.add(R.drawable.aazzzzzx_large);
        allImageIds.add(R.drawable.aazzzzzy_large);
        allImageIds.add(R.drawable.aazzzzzz_large);
        allImageIds.add(R.drawable.aazzzzzza_large);
        allImageIds.add(R.drawable.aazzzzzzb_large);
        allImageIds.add(R.drawable.aazzzzzzc_large);
        allImageIds.add(R.drawable.aazzzzzzd_large);
        allImageIds.add(R.drawable.aazzzzzze_large);

         */


        allImageIds.add(R.drawable.aa_imnothing);
        allImageIds.add(R.drawable.ab_imnothing);
        allImageIds.add(R.drawable.ac_imnothing);
        allImageIds.add(R.drawable.ad_imnothing);
        allImageIds.add(R.drawable.ae_imnothing);
        allImageIds.add(R.drawable.af_imnothing);
        allImageIds.add(R.drawable.ag_imnothing);
        allImageIds.add(R.drawable.ah_imnothing);
        allImageIds.add(R.drawable.ai_imnothing);
        allImageIds.add(R.drawable.aj_imnothing);
        allImageIds.add(R.drawable.ak_imnothing);
        allImageIds.add(R.drawable.al_imnothing);
        allImageIds.add(R.drawable.am_imnothing);
        allImageIds.add(R.drawable.an_imnothing);
        allImageIds.add(R.drawable.ao_imnothing);
        allImageIds.add(R.drawable.ap_imnothing);
        allImageIds.add(R.drawable.aq_imnothing);
        allImageIds.add(R.drawable.ar_imnothing);
        allImageIds.add(R.drawable.as_imnothing);
        allImageIds.add(R.drawable.at_imnothing);
        allImageIds.add(R.drawable.au_imnothing);
        allImageIds.add(R.drawable.av_imnothing);
        allImageIds.add(R.drawable.aw_imnothing);
        allImageIds.add(R.drawable.ax_imnothing);
        allImageIds.add(R.drawable.ay_imnothing);
        allImageIds.add(R.drawable.az_imnothing);
        allImageIds.add(R.drawable.ba_imnothing);
        allImageIds.add(R.drawable.bb_imnothing);
        allImageIds.add(R.drawable.bc_imnothing);
        allImageIds.add(R.drawable.bd_imnothing);
        allImageIds.add(R.drawable.be_imnothing);
        allImageIds.add(R.drawable.bf_imnothing);
        allImageIds.add(R.drawable.bg_imnothing);
        allImageIds.add(R.drawable.bh_imnothing);
        allImageIds.add(R.drawable.bi_imnothing);
        allImageIds.add(R.drawable.bj_imnothing);
        allImageIds.add(R.drawable.bk_imnothing);
        allImageIds.add(R.drawable.bl_imnothing);
        allImageIds.add(R.drawable.bm_imnothing);
        allImageIds.add(R.drawable.bn_imnothing);
        allImageIds.add(R.drawable.bo_imnothing);
        allImageIds.add(R.drawable.bp_imnothing);
        allImageIds.add(R.drawable.bq_imnothing);
        allImageIds.add(R.drawable.br_imnothing);
        allImageIds.add(R.drawable.bs_imnothing);
        allImageIds.add(R.drawable.bt_imnothing);
        allImageIds.add(R.drawable.bu_imnothing);
        allImageIds.add(R.drawable.bv_imnothing);
        allImageIds.add(R.drawable.bw_imnothing);
        allImageIds.add(R.drawable.bx_imnothing);
        allImageIds.add(R.drawable.by_imnothing);
        allImageIds.add(R.drawable.bz_imnothing);




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

        return allTempleInfoFileIds;

    }



    }

