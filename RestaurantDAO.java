package DeliveryVO;

import java.util.HashMap;
import java.util.Map;

public class RestaurantDAO {

    private static Map<String, Category> categories = new HashMap<>();
    private static Map<String, Restaurant> restaurantMap = new HashMap<>();
    public static void init(FoodDeliveryApp app) {

        Category korean = new Category("한식");
        Category chinese = new Category("중식");
        Category japanese = new Category("일식");
        Category western = new Category("양식");
        Category chicken = new Category("치킨");
        Category snackFood = new Category("분식");
        Category fastFood = new Category("패스트푸드");
        Category meat = new Category("고기");
        Category cafe = new Category("카페/디저트");

        //한식 메뉴 추가
        Restaurant koreanRestaurant1 = new Restaurant("북촌도담", 4.2, 2.0, 2000);
        koreanRestaurant1.addMenu(new Menu("소고기 뭇국",9000,"고소하고 시원한 맛이 매력적인 소고기무국"));
        koreanRestaurant1.addMenu(new Menu("김치찜(2인)",22000,"밥도둑 돼지고기 김치찜"));
        koreanRestaurant1.addMenu(new Menu("보쌈(중)",30000,"잡내없이 촉촉한 보쌈"));
        koreanRestaurant1.addMenu(new Menu("낙지볶음(소)",27000,"쓰러진 소도 벌떡 일으킨다는 낙지로 만든 낙지볶음"));

        Restaurant koreanRestaurant2 = new Restaurant("일품돼지국밥", 4.9,2.5,3000);
        koreanRestaurant2.addMenu(new Menu("양평해장국",11000,"식감이 좋은 벌집양과 선지, 우거지의 환상조합"));
        koreanRestaurant2.addMenu(new Menu("뼈다귀해장국",12000,"살이 많은 목뼈와 배추우거지의 조합"));
        koreanRestaurant2.addMenu(new Menu("돼지국밥",11000,"깊은 맛과 깔끔한 맛의 돼지국밥"));
        koreanRestaurant2.addMenu(new Menu("순살국밥",12000,"부드럽고 씹을수록 고소한 고기"));

        Restaurant koreanRestaurant3 = new Restaurant("내림손삼계탕", 5.0,1.2,1500);
        koreanRestaurant3.addMenu(new Menu("삼계탕", 17000,"삼복더위 이기는 맛과 영양!"));
        koreanRestaurant3.addMenu(new Menu("한방삼계탕", 20000,"먹으면 절대 아플 수 없는 맛!"));
        koreanRestaurant3.addMenu(new Menu("전복삼계탕",25000,"전복과 삼계탕의 만남은 끝판왕!"));
        koreanRestaurant3.addMenu(new Menu("옻삼계탕",20000,"몸을 차신 분들에게 추천!"));

        Restaurant koreanRestaurant4 = new Restaurant("조가비", 3.9, 1.5,1000);
        koreanRestaurant4.addMenu(new Menu("조개단골", 31000,"싱싱한 조개로만 엄선!"));
        koreanRestaurant4.addMenu(new Menu("생문어숙회",35000,"싱싱하고 몸에 좋은 돌문어로 술안주로도 제격!"));
        koreanRestaurant4.addMenu(new Menu("해물파전",22000,"담백하고 바삭한 파전에 탱긍탱글 해물이 듬뿍!"));
        koreanRestaurant4.addMenu(new Menu("1인 조개전골(비조리)",22000, "싱싱한 조개들을 먹고 싶으면!"));

        Restaurant koreanRestaurant5 = new Restaurant("박가부대&치즈 닭갈비 종로2가점", 4.0,2.0,2000);
        koreanRestaurant5.addMenu(new Menu("1인 부대찌개 도시락",11500,"사골육수로 끓여 국물맛이 일품인!"));
        koreanRestaurant5.addMenu(new Menu("(리얼)한우 곱도리탕", 16000,"100% 순살 닭다리살의 얼큰 닭볶음탕과 고소한 대창으로 일품 국물맛을 낸다!"));
        koreanRestaurant5.addMenu(new Menu("수제햄부대찌개",13500,"다양하게 즐길 수 있는 맛있는 수제햄"));
        koreanRestaurant5.addMenu(new Menu("한돈 김치찌개",10000, "남도의 깊은 맛을 담은 포기김치와 국내산 돼지고기로 푹 끓인 김치찌개"));

        //한식 카테고리에 음식점 추가
        korean.addRestaurant(koreanRestaurant1);
        korean.addRestaurant(koreanRestaurant2);
        korean.addRestaurant(koreanRestaurant3);
        korean.addRestaurant(koreanRestaurant4);
        korean.addRestaurant(koreanRestaurant5);

        //중식 메뉴 추가
        Restaurant chineseRestaurant1 = new Restaurant("춘리마라탕 서대문점",5.0,2.1,2500);
        chineseRestaurant1.addMenu(new Menu("대표 마라탕", 9900, "선배! 마라탕 사주세요!!"));
        chineseRestaurant1.addMenu(new Menu("불맛 마라샹궈", 15900, "니들이 불맛을 알어?!"));
        chineseRestaurant1.addMenu(new Menu("꿔바로우", 12900, "새콤바삭 꿔바로우!"));
        chineseRestaurant1.addMenu(new Menu("양저우볶음밥", 7000, "중국요리를 처음 먹는다면 이것부터!"));

        Restaurant chineseRestaurant2 = new Restaurant("개화", 4.7, 1.1, 1000);
        chineseRestaurant2.addMenu(new Menu("삼선짬뽕", 12000, "짬뽕이 끌릴때가 있지!"));
        chineseRestaurant2.addMenu(new Menu("깐쇼새우",38000,"달콤한 소스가 묻어나는 통통한 새우를 보고싶어?"));
        chineseRestaurant2.addMenu(new Menu("간짜장",9000,"물기없는 짜장을 원할땐?"));
        chineseRestaurant2.addMenu(new Menu("삼선간짜장", 11000, "싱싱한 해산물과 짜장의 조합이란.."));

        Restaurant chineseRestaurant3 = new Restaurant("원보양꼬치", 4.9, 1.5,1500);
        chineseRestaurant3.addMenu(new Menu("양꼬치(10꼬치)",16000, "특별한 고기를 먹고 싶은땐?"));
        chineseRestaurant3.addMenu(new Menu("양갈비살(10꼬치)",19000, "양코치 먹으면 이것도 먹어봐야지!"));
        chineseRestaurant3.addMenu(new Menu("경장육슬", 18000, "돼지고기를 채썬 뒤 경장(첨장)으로 볶아 파, 전병, 건두부와 함께 먹는 중국 베이징의 향토 요리"));
        chineseRestaurant3.addMenu(new Menu("지삼선", 17000, "땅에서 나는 신선한 3가지의 채소들로 만든 요리!"));

        Restaurant chineseRestaurant4 = new Restaurant("홍콩반점0410 대학로점", 4.5, 1.4,2100);
        chineseRestaurant4.addMenu(new Menu("깐풍새우", 20900,"알싸한 청양고추와 깐풍소스! 깔끔하게 매운 통통 새우의 조합이란.."));
        chineseRestaurant4.addMenu(new Menu("[1인분]알찬 미니탕수육 세트",21800, "짜장면 하면 바로 딸려오는 얘.."));
        chineseRestaurant4.addMenu(new Menu("고기짬뽕(면 별도포장)", 10500,  "고기까지 들어간 짬뽕은 반칙이지!"));
        chineseRestaurant4.addMenu(new Menu("짜장면", 7000, "중식특유의 불향이 가득한 명품 짜장면" ));
        chineseRestaurant4.addMenu(new Menu("고추짜장", 8500, "달콤 담백한 짜장면에 청양고추로 아삭한 식감과 매콤함을 살린 고추짜장" ));
        chineseRestaurant4.addMenu(new Menu("쟁반짜장(2인분)", 17000, "둘이서 맛있게" ));
        chineseRestaurant4.addMenu(new Menu("짜장밥(국물제공)", 9500, "짬뽕국물 1개 기본 제공" ));

        Restaurant chineseRestaurant5 = new Restaurant("라화방 마라탕", 4.9, 2.0, 2000);
        chineseRestaurant5.addMenu(new Menu("마라탕",10000,"얼얼함 하면 바로 나!"));
        chineseRestaurant5.addMenu(new Menu("마라샹궈",15000,"마라탕 하면 같이 생각나는 녀석.."));
        chineseRestaurant5.addMenu(new Menu("새우볶음밥",7000,"새우 넣고 볶아볶아!"));
        chineseRestaurant5.addMenu(new Menu("물만두",7000,"한국인들에게 친숙한 만두하면?"));

        //중식 카테고리에 음식점 추가
        chinese.addRestaurant(chineseRestaurant1);
        chinese.addRestaurant(chineseRestaurant2);
        chinese.addRestaurant(chineseRestaurant3);
        chinese.addRestaurant(chineseRestaurant4);
        chinese.addRestaurant(chineseRestaurant5);

        //일식 메뉴 추가
        Restaurant japaneseRestaurant1 = new Restaurant("은행골[종로구청점]", 4.9,1.8,2000);
        japaneseRestaurant1.addMenu(new Menu("도로초밥",32000 ,"혀에서 살살 녹는 초밥"));
        japaneseRestaurant1.addMenu(new Menu("연어초밥",20000 ,"탱글하면서 부드러운 식감"));
        japaneseRestaurant1.addMenu(new Menu("활어초밥",22000 ,"살아 있는 생선을 바로썰어낸 초밥"));
        japaneseRestaurant1.addMenu(new Menu("오도로(대뱃살)",39000 ,"흰 지방 사이에 붉은 살이 물결처럼 들어가 있는 회"));

        Restaurant japaneseRestaurant2 = new Restaurant("코코이찌방[종로타워점]",4.9, 2.2,3000);
        japaneseRestaurant2.addMenu(new Menu("일품돈카츠카레",13900,"하이라이스 같으며 버터향이 나는 카레"));
        japaneseRestaurant2.addMenu(new Menu("알새우&비프샤브오무",17600,"탱글한 새우와 카레가 오므라이스로!"));
        japaneseRestaurant2.addMenu(new Menu("치즈in로스까스카레",14100,"치즈의 짭조름한 맛과 카레를 같이!"));
        japaneseRestaurant2.addMenu(new Menu("하프카라아게&비프카레우동",15800,"바삭한 카라아게와 고기가 들어있는 카레우동"));

        Restaurant japaneseRestaurant3 = new Restaurant("아오리의행방불명[광화문센트럴점]", 4.5,2.2,2500);
        japaneseRestaurant3.addMenu(new Menu("아오리돈코츠라멘",11000,"12시간 정성으로 직접 우려낸 돈.계골 사골 육수에 생면"));
        japaneseRestaurant3.addMenu(new Menu("아오리미소라멘",11000,"12시간 직접우려낸 돈.계골 사골로 된장맛이 나는 육수"));
        japaneseRestaurant3.addMenu(new Menu("아오리마제멘",12000,"소고기와 다양한 재료로 만든 소스에 메밀이 들어간 생면"));
        japaneseRestaurant3.addMenu(new Menu("세트1. 아오리 돈코츠라멘 + TKG(계란간장밥) + 음료",16500,"돼지사골과 닭으로 직접 우린 돈코츠육수로 만든 아오리 돈코츠라멘 + TKG(간장계란밥) + 음료"));

        Restaurant japaneseRestaurant4 = new Restaurant("식당진", 5.0,2.2,2000);
        japaneseRestaurant4.addMenu(new Menu("에비동(새우튀김덮밥)",9500,"왕새우, 중새우, 양파, 계란, 덮밥소스 "));
        japaneseRestaurant4.addMenu(new Menu("텐동(모듬튀김덮밥)",10000,"단호박, 고구마, 연근, 가지, 새송이, 김, 왕새우"));
        japaneseRestaurant4.addMenu(new Menu("사케동(생연어덮밥)",12000,"노르웨이 생연어, 생와사비, 김가루"));
        japaneseRestaurant4.addMenu(new Menu("우나기동(장어덮밥)",14000,"장어, 덮밥소스, 초생강"));

        Restaurant japaneseRestaurant5 = new Restaurant("남산밑유부",4.9,3.0,2000 );
        japaneseRestaurant5.addMenu(new Menu("불맛우삼겹 유부",3800,"직화로 살짝 구운 우삼겹과 비전의 소스가 가미된 유부밥"));
        japaneseRestaurant5.addMenu(new Menu("한우육회유부",4300,"고급진 한우를 고소한 참기름에 살살살 비벼 고소함과 톡톡 터지는 육즙"));
        japaneseRestaurant5.addMenu(new Menu("매콤갈릭새우 유부",3800,"탱글한 식감이 살아있는 새우에 청양고추의 매콤함과 갈릭의 쌉싸름"));
        japaneseRestaurant5.addMenu(new Menu("연어타다끼 유부",4300,"청정 노르웨이 산 슈페리얼급 연어에 불맛"));

        //일식 카테고리에 음식점 추가
        japanese.addRestaurant(japaneseRestaurant1);
        japanese.addRestaurant(japaneseRestaurant2);
        japanese.addRestaurant(japaneseRestaurant3);
        japanese.addRestaurant(japaneseRestaurant4);
        japanese.addRestaurant(japaneseRestaurant5);

        //양식 메뉴 추가
        Restaurant westernRestaurant1 = new Restaurant("파스타입니다[종로점]", 4.9, 1.1, 1000);
        westernRestaurant1.addMenu(new Menu("봉골레 파스타(살짝매콤)",11900,"속이 알찬 바지락을 듬뿍넣어 시원하고 감칠맛이 확도는 봉골레 파스타"));
        westernRestaurant1.addMenu(new Menu("매콤 크림 파스타",15300,"베이컨과 새우 2마리가 들어가 느끼함을 잡아줄 매콤한 크림소스 파스타"));
        westernRestaurant1.addMenu(new Menu("우삼겹 알리오올리오 파스타",10900,"우삼겹에 마늘향을 입혀 더욱 풍미가 깊은 퓨전식 알리오올리오"));
        westernRestaurant1.addMenu(new Menu("한국 K로제 파스타(꾸덕꾸덕)",11900,"비엔나 소세지도 4대나 들어간 이색 K로제 파스타"));

        Restaurant westernRestaurant2 = new Restaurant("슈가스컬", 4.7, 1.2, 1500);
        westernRestaurant2.addMenu(new Menu("카니타스 타코 3ps",14900,"다양한 향신료와 오렌지주스를 넣어 조리 후 그리들에 구워낸 돼지고기 타코"));
        westernRestaurant2.addMenu(new Menu("바바코아 타코 3ps",18900,"치폴레, 고추, 양파, 통마늘, 정향 등의 향신료를 넣고 조리한 소고기 타코"));
        westernRestaurant2.addMenu(new Menu("포솔레",11900,"통돼지고기와 족발을 넣어 부드럽게 끓여낸 매콤한 멕시코 전통 스프요리"));
        westernRestaurant2.addMenu(new Menu("타코미트 타키토스",18000,"타코시즈닝을 가미한 다진 소고기를 콘또띠아에 말아 바삭하게 튀겨낸 요리"));

        Restaurant westernRestaurant3 = new Restaurant("탭샵바[청계천점]",5.0,0.5,1000);
        westernRestaurant3.addMenu(new Menu("하몽 부라타",19900,"하몽+부라타+ 사워도우 위에 척척"));
        westernRestaurant3.addMenu(new Menu("아라비아타 리조또",14500,"아라비아따 소스와 해산물이 어우러진 매콤한 리조또"));
        westernRestaurant3.addMenu(new Menu("그릴드 소시지, 감자튀김",18900,"굴, 크림, 우유가 들어가 부드러운 크림 파스타"));
        westernRestaurant3.addMenu(new Menu("엔초비 파스타",13500,"루꼴라와 방울토마토 엔초비가 들어간 파스타"));

        Restaurant westernRestaurant4 = new Restaurant("엘까르니따스[익선점]", 5.0,1.2,2000);
        westernRestaurant4.addMenu(new Menu("CARNITAS TACO 까르니따스",5000,"콘또띠아에 삶은 돼지고기와 양파 고수가 올라간 멕시칸 푸드"));
        westernRestaurant4.addMenu(new Menu("FAJITA SALAD 파히타 샐러드",17900,"그릴에서 구운 스테이크와 치킨이 함께 제공되는 샐러드"));
        westernRestaurant4.addMenu(new Menu("SHRIMP TACO 쉬림프",6500,"콘또띠아에 새우와 각종 야채, 고수가 올라간 멕시칸 리얼 푸드"));
        westernRestaurant4.addMenu(new Menu("FAJITA CHICKEN 파히타 치킨 퀘사디아",14900,"밀또띠아에 치즈와 그릴에 구운 닭가슴살을 넣어 반달모양으로 구어낸 메뉴"));

        Restaurant westernRestaurant5 = new Restaurant("슬로우캘리[종로점]",4.8,1.0,1500);
        westernRestaurant5.addMenu(new Menu("클래식 연어 포케",12500,"특제 간장 베이스와 클래식 소스가 어우러진 연어"));
        westernRestaurant5.addMenu(new Menu("스파이시 연어 포케",12500,"스리라차 마요 베이스와 감칠맛 나는 매콤한 소스가 어우러진 연어"));
        westernRestaurant5.addMenu(new Menu("블랙페퍼 치킨 보울",11500,"아일랜드풍의 달콤한 통후추 소스와 닭다리살"));
        westernRestaurant5.addMenu(new Menu("닭가슴살 에그 포케",11500,"고단백의 닭가슴살, 계란에 슬로우캘리 소이소스로 감칠맛을 더한 포케"));

        //양식 카테고리에 음식점 추가
        western.addRestaurant(westernRestaurant1);
        western.addRestaurant(westernRestaurant2);
        western.addRestaurant(westernRestaurant3);
        western.addRestaurant(westernRestaurant4);
        western.addRestaurant(westernRestaurant5);

        //치킨 메뉴 추가
        Restaurant chickenRestaurant1 = new Restaurant("BHC 서대문점",4.8,2.0,2000);
        chickenRestaurant1.addMenu(new Menu("뿌링클",21000,""));
        chickenRestaurant1.addMenu(new Menu("HOT 후라이드",21000,""));
        chickenRestaurant1.addMenu(new Menu("바삭클",18000,"바삭함!!"));
        chickenRestaurant1.addMenu(new Menu("맛초킹(매콤짭짤)",21000,""));

        Restaurant chickenRestaurant2 = new Restaurant("교촌치킨 종로1호점", 4.9, 0.1, 1000);
        chickenRestaurant2.addMenu(new Menu("레드 오리지날(한마리)",20000,"국내산 청양 홍고추의 매콤함"));
        chickenRestaurant2.addMenu(new Menu("교촌옥수수통안심",23000,""));
        chickenRestaurant2.addMenu(new Menu("교촌점보윙",19000,"마늘간장소스의 교촌윙을 점보로!!"));
        chickenRestaurant2.addMenu(new Menu("허니갈릭점보윙",19000,""));

        Restaurant chickenRestaurant3 = new Restaurant("BBQ 종로종각점",4.9,0.1,1000);
        chickenRestaurant3.addMenu(new Menu("황금올리브치킨",23000,""));
        chickenRestaurant3.addMenu(new Menu("자메이카 소떡만나치킨",24000,""));
        chickenRestaurant3.addMenu(new Menu("빠리치킨",24000,"BBQ 특제 칸풍소스에 향긋한 대파, 고추까지 곁들여 웍에 볶은 불맛"));
        chickenRestaurant3.addMenu(new Menu("크런치 순살크래커",24000,"빵가루 크럼을 입혀 바삭하게!"));

        Restaurant chickenRestaurant4 = new Restaurant("자담치킨",4.7, 1.0,1500);
        chickenRestaurant4.addMenu(new Menu("맵슐랭순살치킨",25000,"정통 마요소스와 청양고추가 한입에 쏙 먹기 쉬운!"));
        chickenRestaurant4.addMenu(new Menu("왓더핫치킨",23000,"불닭소스와 쓰리라차 소스에 크러시드 레드페퍼까지 더해진 맛있게 매운맛"));
        chickenRestaurant4.addMenu(new Menu("마튀니치킨",23000,"허니갈릭소스, 마늘 후레이크 시즈닝, 바삭한 통마늘 토핑"));
        chickenRestaurant4.addMenu(new Menu("소보로치킨",20000,"올록볼록 바삭한 튀김옷"));

        Restaurant chickenRestaurant5 = new Restaurant("바른치킨 종각역점", 4.7, 1.4,2000);
        chickenRestaurant5.addMenu(new Menu("현미바삭",19000,"바른치킨만의 특별한 3C공법으로 더 바삭한!"));
        chickenRestaurant5.addMenu(new Menu("핫현미바삭",21900,""));
        chickenRestaurant5.addMenu(new Menu("치킨만",17900,""));
        chickenRestaurant5.addMenu(new Menu("통곡물간장치킨",21900,"간장소스와 통곡물 토핑으로 식감을 살린!"));

        //치킨 카테고리에 음식점 추가
        chicken.addRestaurant(chickenRestaurant1);
        chicken.addRestaurant(chickenRestaurant2);
        chicken.addRestaurant(chickenRestaurant3);
        chicken.addRestaurant(chickenRestaurant4);
        chicken.addRestaurant(chickenRestaurant5);

        //분식 메뉴 추가
        Restaurant snackFoodRestaurant1 = new Restaurant("와차떡볶이",4.8,1.5,2000);
        snackFoodRestaurant1.addMenu(new Menu("와차 떡볶이",5000,"와차만의 소스에 쌀떡 고유함의 쫀득함"));
        snackFoodRestaurant1.addMenu(new Menu("(함경도 아바이식) 찰순대",5500,"고소하고 쫄깃쫄깃 당면"));
        snackFoodRestaurant1.addMenu(new Menu("(시장스타일) 꼬마김밥",4200,"한번 맛보면 멈출 수 없는~"));
        snackFoodRestaurant1.addMenu(new Menu("(매일새기름) 모듬튀김",4700,"바삭바삭 비오는날 생각나는..."));

        Restaurant snackFoodRestaurant2 = new Restaurant("말죽거리 꽈배기",4.9, 1.3, 1500);
        snackFoodRestaurant2.addMenu(new Menu("찹쌀꽈배기",1000,"쫄깃쫄깃 건강한 찹쌀꽈배기"));
        snackFoodRestaurant2.addMenu(new Menu("찹쌀소세지핫도그",2500,"쫄깃한 찹쌀안에 오독오독 소세지"));
        snackFoodRestaurant2.addMenu(new Menu("찹쌀도넛(완두콩앙금)",1000,"찹쌀가루로 반죽하여 튀긴 도넛안에 완두콩앙금이 듬뿍"));
        snackFoodRestaurant2.addMenu(new Menu("찹쌀단팥도넛",1500,"쫄깃쫄깃한 식감이 매력적인 단팥도넛"));

        Restaurant snackFoodRestaurant3 = new Restaurant("오토김밥[인사동점]",4.7,1.1,1000);
        snackFoodRestaurant3.addMenu(new Menu("고추냉이김밥",6000,"제공되는 와사비 간장을 더하면 초밥으로 즐기실수 있습니다"));
        snackFoodRestaurant3.addMenu(new Menu("오토김밥",6000,"와사비 간장 제공되지 않습니다"));
        snackFoodRestaurant3.addMenu(new Menu("스팸김밥",6000,"두툼한 두께와 고유의 맛"));
        snackFoodRestaurant3.addMenu(new Menu("닭강정",22000,"매운고추가 들어간 칼칼한 닭강정"));

        Restaurant snackFoodRestaurant4 = new Restaurant("명랑핫도그",4.8,0.7,1000 );
        snackFoodRestaurant4.addMenu(new Menu("명랑 핫도그",2300,"쌀가루를 넣어 쫄깃함을 더한 명랑 오리지널 핫도그"));
        snackFoodRestaurant4.addMenu(new Menu("감자통모짜 핫도그",3800,"100% 모짜렐라치즈에 고소하고 바삭한 감자가 어우러져 고급스러움을 더한 핫도그"));
        snackFoodRestaurant4.addMenu(new Menu("텍사스 핫도그",4500,"진한 육즙과 탁월한 풍미를 자랑하는 미국산 쟌슬빌 소시지에 짭짤한 페퍼로니"));
        snackFoodRestaurant4.addMenu(new Menu("통모짜 핫도그",3100,"처음부터 끝까지 진한 모짜렐라치즈의 풍미를 느낄 수 있는 핫도그"));

        Restaurant snackFoodRestaurant5 = new Restaurant("도시로 온 가래떡 방앗간 떡볶이", 4.9,2.1,2000 );
        snackFoodRestaurant5.addMenu(new Menu("떡볶이",6500,"당일 뽑아 쫀득한 통가래떡으로 만든 맵달달 가래떡 쌀떡볶이"));
        snackFoodRestaurant5.addMenu(new Menu("부산꼬치오뎅 3개",4500,"통통한 어묵 꼬치 3개와 깔끔하고 담백한 어묵국물"));
        snackFoodRestaurant5.addMenu(new Menu("수제오징어튀김 2개",3000,"쫀쫀짭잘하고 바삭한 튀김옷을 입은 수제오징어튀김"));
        snackFoodRestaurant5.addMenu(new Menu("수제등심돈까스",12500,"수제로 만든 등심이 들어간 돈까스"));

        //분식 카테고리에 음식점 추가
        snackFood.addRestaurant(snackFoodRestaurant1);
        snackFood.addRestaurant(snackFoodRestaurant2);
        snackFood.addRestaurant(snackFoodRestaurant3);
        snackFood.addRestaurant(snackFoodRestaurant4);
        snackFood.addRestaurant(snackFoodRestaurant5);

        //패스트푸드 메뉴 추가
        Restaurant fastFoodRestaurant1 = new Restaurant("쉐이크쉑",4.9,1.4,1000);
        fastFoodRestaurant1.addMenu(new Menu("스모크쉑",12100,"애플 우드 칩으로 베이컨, 체리페퍼, 비프패티, 쉑소스가 토핑된!"));
        fastFoodRestaurant1.addMenu(new Menu("쉑버거",9700,"비프패티, 토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        fastFoodRestaurant1.addMenu(new Menu("쉑 스택",16500,"버섯패티, 비프패티와 함께 토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        fastFoodRestaurant1.addMenu(new Menu("치킨쉑",9000,"닭가슴 통살과 양상추, 피클, 허브 마요 소스가 토핑된 치킨버거"));

        Restaurant fastFoodRestaurant2 = new Restaurant("폭풍토핑 피자스톰 마포점",4.7,2.5,2000);
        fastFoodRestaurant2.addMenu(new Menu("88페퍼로니",16900,"추억의 페퍼로니 피자.."));
        fastFoodRestaurant2.addMenu(new Menu("딥체다치즈 베이컨",16900," 깊은 체다치즈 향미, 짭잘바삭 베이컨의 만남"));
        fastFoodRestaurant2.addMenu(new Menu("허리케인골드",21900,"고구마 회오리와 베이컨 폭풍! 피자스톰의 시그니처!!"));
        fastFoodRestaurant2.addMenu(new Menu("보스 포테이토",21900,"담백한 두 종류의 감자토핑!! 최종보스라서 BOSS!!"));

        Restaurant fastFoodRestaurant3 = new Restaurant("써브웨이 종로점", 4.5,0.7,1000);
        fastFoodRestaurant3.addMenu(new Menu("이탈리안 비엠티(15cm세트)",9700,"햄과 토마토 야채들이 토핑된 푸짐한 한끼!"));
        fastFoodRestaurant3.addMenu(new Menu("스테이크 & 치즈(15cm세트)",11000,"스테이크와 치즈의 환상 조합!"));
        fastFoodRestaurant3.addMenu(new Menu("로스트 치킨(15cm세트)",10300,"오븐에 구운 담백한 닭가슴살 치킨 패티"));
        fastFoodRestaurant3.addMenu(new Menu("로티세리 바베큐 치킨(15cm세트)",10300,"닭가슴살과 다리살을 써브웨이만의 비율로 배합한 치킨"));

        Restaurant fastFoodRestaurant4 = new Restaurant("이삭토스트 종로피카디리점",4.7,1.3,1500);
        fastFoodRestaurant4.addMenu(new Menu("햄스페셜 토스트",4000,"햄 치즈에 양배추 더해져 풍성!"));
        fastFoodRestaurant4.addMenu(new Menu("베이컨 포테이토 피자",5600,"해시브라운, 베이컨, 치즈로 만나는!"));
        fastFoodRestaurant4.addMenu(new Menu("소이 크런치 치킨",5300,"통닭다리살 치킨에 단짠 허니소이소스, 크런치 아몬드의 조화"));
        fastFoodRestaurant4.addMenu(new Menu("스크램블 더블모짜",5200,"스크램블과 햄, 더블 모짜렐라의 부드러움!"));

        Restaurant fastFoodRestaurant5= new Restaurant("마디그라 종로점",4.4,1.0,1500);
        fastFoodRestaurant5.addMenu(new Menu("뉴올리언스 버거 SINGLE",11900,"홈메이드 소고기 100% 패티, 진한치즈 가득!"));
        fastFoodRestaurant5.addMenu(new Menu("딥 사우스 버거 DOUBLE (중간 매운맛)",16400,"홈메이드 소고기 100% 패티, 아메리칸 치즈, 할라피뇨퓨레 (매콤)"));
        fastFoodRestaurant5.addMenu(new Menu("잠발라야 라이스",16500,"케이준 스파이스에 치킨, 새우를 밥과 함께 요리한 매콤한 남부식 잠발라야"));
        fastFoodRestaurant5.addMenu(new Menu("루이지애나 치킨 버거",11000,"버터밀크에 특제 파우더로 튀겨낸 케이준 스타일 치킨버거"));

        //패스트푸드 카테고리에 음식점 추가
        fastFood.addRestaurant(fastFoodRestaurant1);
        fastFood.addRestaurant(fastFoodRestaurant2);
        fastFood.addRestaurant(fastFoodRestaurant3);
        fastFood.addRestaurant(fastFoodRestaurant4);
        fastFood.addRestaurant(fastFoodRestaurant5);

        //고기 메뉴 추가
        Restaurant meatRestaurant1 = new Restaurant("레전드 고기한상[용산점]",4.9,2.4,2000);
        meatRestaurant1.addMenu(new Menu("보들 보들 맛있는 고기만 500g(삼겹살, 소고기 선택)",18900,"only 고기만 필요하신 분들을 위해서 준비했습니다."));
        meatRestaurant1.addMenu(new Menu("고기듬뿍 얼큰 김치찌개 (대) + 흑미밥(혼밥세트)",9900,"고기듬뿍 얼큰 김치찌개 + 흑미밥"));
        meatRestaurant1.addMenu(new Menu("꼬들담백 항정살 400g",23900,"항정살 400g + 소스선택1"));
        meatRestaurant1.addMenu(new Menu("레전드 실속 고기한상(혼술강추)공기밥 별도 1~2인분",29900,"고기선택 + 모짜렐라 콘치즈 + 품질좋은 육회 + 수제어묵탕 + 명이나물 + 두부김치"));

        Restaurant meatRestaurant2 = new Restaurant("워디 Vodiy",4.0,1.5,1500);
        meatRestaurant2.addMenu(new Menu("전통 양꼬치 샤슬릭(SHASHILK KUSKAVOY)",9500,"크게 뭉텅뭉텅 썬 양고기 본연의 맛"));
        meatRestaurant2.addMenu(new Menu("전통 소고기 샤슬릭(SHASHILIK QIYMA",8500,"크게 뭉텅뭉텅 썬 소고기의 맛"));
        meatRestaurant2.addMenu(new Menu("자카즈 오쉬 (ZAKAZ OSH)",12000,"소고기와 기름이 많은 오쉬"));
        meatRestaurant2.addMenu(new Menu("코존 케밥 (QOZON KABOB)",14000,"양갈비 바베큐와 감자튀김이 같이 있는 케밥"));

        Restaurant meatRestaurant3 = new Restaurant("하남돼지집[서대문역점]",5.0,2.2,1000);
        meatRestaurant3.addMenu(new Menu("한돈가브리살",17000,"부드럽고 풍미가 좋아서 인기가 좋은 부위입니다"));
        meatRestaurant3.addMenu(new Menu("한돈항정살",18000,"특유의 식감과 고소한맛이 일품"));
        meatRestaurant3.addMenu(new Menu("참숯한돈삼겹살",16000,"한우1+이상의 삼겹살"));
        meatRestaurant3.addMenu(new Menu("500도 참숯초벌 한돈특목살",16000,"500도 최고급 참숯에서 초벌해 향이 좋습니다"));

        Restaurant meatRestaurant4 = new Restaurant("홍곱창[대학로직영점]",4.8,1.1,2500);
        meatRestaurant4.addMenu(new Menu("야채곱창",13000,"기본곱창"));
        meatRestaurant4.addMenu(new Menu("양념막창",15000,"매콤 달콤"));
        meatRestaurant4.addMenu(new Menu("데리야끼막창",15000,"어머! 1위 메뉴"));
        meatRestaurant4.addMenu(new Menu("소금구이막창",15000,"막창본연의 맛"));

        Restaurant meatRestaurant5 = new Restaurant("바른새우",5.0,1.1,1000);
        meatRestaurant5.addMenu(new Menu("(다이어트에좋은) 흰다리새우 새우소금구이세트 + 초장 소 약24미 600g",26000,"전메뉴 찜누르시고 요청사함에 리뷰신청과 품목적어주세요"));
        meatRestaurant5.addMenu(new Menu("(다이어트굿) 블랙타이거 새우소금구이세트+초장 12미 500g",26000,"전메뉴 찜누르시고 요청사함에 리뷰신청과 품목적어주세요"));
        meatRestaurant5.addMenu(new Menu("새콤달콤칠리튀김새우(술안주, 밥반찬 상황정리)",24000,"튀김옷 입힌 새우를 새콤달콤한 칠리소스에 맛있게 조리합니다"));
        meatRestaurant5.addMenu(new Menu("(검증완료) 흰다리 알새우찜 (껍질빼고 스팀조리) 25미(중)",23000,"흰다리새우 알새우찜은 기존 매장에서 새우25미 사이즈를 껍질을 벗기고 조리했습니다"));

        //고기 카테고리에 음식점 추가
        meat.addRestaurant(meatRestaurant1);
        meat.addRestaurant(meatRestaurant2);
        meat.addRestaurant(meatRestaurant3);
        meat.addRestaurant(meatRestaurant4);
        meat.addRestaurant(meatRestaurant5);

        //카페 메뉴 추가
        Restaurant cafeRestaurant1 = new Restaurant("와플칸",5.0,1.1,1000);
        cafeRestaurant1.addMenu(new Menu("프렌치 크로플",2800,"설탕시럽+아몬드입니다. 기본으로 생크림은 올라가지 않아요!"));
        cafeRestaurant1.addMenu(new Menu("통사과잼 와플",5500,"와플칸만의 곡물가루와 검은깨가 들어간 건강하고 맛있는 와플빵"));
        cafeRestaurant1.addMenu(new Menu("초코칩 와플",5000,"당충전 하기 좋은 달달한 와플"));
        cafeRestaurant1.addMenu(new Menu("통블루베리잼 와플",5500,"상큼해서 물리지 않는 블루베리와플"));

        Restaurant cafeRestaurant2 = new Restaurant("엘리스파이[광화문직영점]",4.9,1.0,1500);
        cafeRestaurant2.addMenu(new Menu("나비파이",4300,"바삭한 페스츄리 위에 달콤한 딸기시럽과 의성조청이 발린 파이"));
        cafeRestaurant2.addMenu(new Menu("파이카스테라",6000,"겹겹이 쌓인 파이지 사이에 부드러운 카스테라와 크림"));
        cafeRestaurant2.addMenu(new Menu("에그타르트",3900,"부드러운 에그 필링이 들어있는 촉촉한 에그타르트"));
        cafeRestaurant2.addMenu(new Menu("피칸호두타르트(판)",46000,"호두에 피칸까지 아낌없이 넣어 한층 더 고소한 타르트"));

        Restaurant cafeRestaurant3 = new Restaurant("까치화방[종로점]",5.0,1.4,500);
        cafeRestaurant3.addMenu(new Menu("허니 아이스크림 크로플",10800,"프랑스산 버터크로플에 깊고 진한 나뚜루 바닐라 한스쿱"));
        cafeRestaurant3.addMenu(new Menu("까치설화(아인슈페너 Iced Only)",6200,"까치화방의 시그니처 메뉴로 쫀득한 크림을 듬뿍 올린 아인슈페너"));
        cafeRestaurant3.addMenu(new Menu("밀크청(머스캣 밀크티)",6500,"머스캣의 향긋한 풍미가 감도는 부드러운 프리미엄 블렌딩 밀크티"));
        cafeRestaurant3.addMenu(new Menu("말차가나슈케이크(조각)",6800,"진한 말차크림에 꾸덕한 초코시트 우유맛 크림치즈 크림"));

        Restaurant cafeRestaurant4 = new Restaurant("메고지고 떡창고[을지로입구점]",5.0,1.0,1000);
        cafeRestaurant4.addMenu(new Menu("두바이초콜릿찹쌀떡(8개입)",23900,"찹쌀떡 안에 카다이프와 피스타치오가 듬뿍"));
        cafeRestaurant4.addMenu(new Menu("찹쌀빙고카이막(9개입)",16900,"카이막은 우유를 굳혀 만든 크림으로 튀르키예의 전통 디저트입니다"));
        cafeRestaurant4.addMenu(new Menu("라이스파이 초코(10개)",12900,"부르더운 쌀 카스테라와 쫀득한 인절미로 만든 쌀빵 초코맛"));
        cafeRestaurant4.addMenu(new Menu("개성주악(4개)",9900,"전통 방식으로 만들어 쫀득하고 한 입 물면 달달하게 조청 즙이 흘러 나옵니다~"));

        Restaurant cafeRestaurant5 = new Restaurant("을지로 문덕커피",5.0,1.1,1000);
        cafeRestaurant5.addMenu(new Menu("모둠과일 바블로바",18000,"과일은 계절에 따라 변동 될 수 있으며 최대한 선도를 유지 하려고 노력하고 있습니다."));
        cafeRestaurant5.addMenu(new Menu("(바삭쫀득)샤인머스켓 파블로바 케이크",22000,"귀족과일 샤인머스켓이 통째로 들어간 파블로바"));
        cafeRestaurant5.addMenu(new Menu("빅사이즈 모둠과일화채",17000,"신선한 과일과 녹아도 싱거워 지지않는 우유 100%"));
        cafeRestaurant5.addMenu(new Menu("(2~3인분 거뜬) 생파인애플 빙수",24000,"생과일에 어울리는 최적의 샤베트 눈꽃 얼음에 새콤달콤한 생파인애플"));

        //카페 카테고리에 음식점 추가
        cafe.addRestaurant(cafeRestaurant1);
        cafe.addRestaurant(cafeRestaurant2);
        cafe.addRestaurant(cafeRestaurant3);
        cafe.addRestaurant(cafeRestaurant4);
        cafe.addRestaurant(cafeRestaurant5);

        //특정 카테고리 가져오는 메소드
        categories.put("한식", korean);
        categories.put("중식", chinese);
        categories.put("일식", japanese);
        categories.put("양식", western);
        categories.put("치킨", chicken);
        categories.put("분식", snackFood);
        categories.put("패스트푸드", fastFood);
        categories.put("고기", meat);
        categories.put("카페/디저트", cafe);

        // 카테고리들을 앱에 설정
        app.addCategory(korean);
        app.addCategory(chinese);
        app.addCategory(japanese);
        app.addCategory(western);
        app.addCategory(chicken);
        app.addCategory(snackFood);
        app.addCategory(fastFood);
        app.addCategory(meat);
        app.addCategory(cafe);



    }

    public static Category getCategory(String categoryName){
        return categories.get(categoryName);
    }

    // 한식 음식점 리스트를 반환하는 메서드 추가
    public static Restaurant[] getKoreanRestaurants() {
        Category korean = categories.get("한식");
        return korean != null ? korean.getRestaurantList().toArray(new Restaurant[0]) : new Restaurant[0];
    }

    // 기타 음식점 정보 가져오는 메서드들 (배달비, 평점 등)
    public static Restaurant getRestaurant(String restaurantName) {
        return restaurantMap.get(restaurantName);
    }




//    //음식점 이름을 반환
//    public static  Restaurant getRestaurant(String restaurantName){
//        return restaurantMap.get(restaurantName);
//    }
//    //음식점의 배달비를 반환
//    public static long getDeliveryPrice(String restaurantName){
//        return getRestaurant(restaurantName).getDeliveryPrice();
//    }
//    //음식점의 평점을 반환
//    public static double getRestaurantScore(String restaurantName){
//        return getRestaurant(restaurantName).getRestaurantScore();
//    }
//    //음식점의 거리를 반환
//    public static double getRestaurantDistance(String restaurantName){
//        return getRestaurant(restaurantName).getDistance();
//    }
//    //메뉴의 설명을 반환
//    public static String getRestaurantDescription(Menu menu){
//        return menu.getDescription();
//    }


}
