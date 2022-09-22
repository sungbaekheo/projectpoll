import java.util.Scanner;

public class PollsPrintMenu {

    Scanner scan = new Scanner(System.in);

    // 설문 프로그램 처음 시작 화면
    public String mainMenu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("        백화점 환경 개선을 위한 이용 고객 대상 설문조사        ");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("\n\n              실행하려는 메뉴를 선택해주세요.");
        System.out.println("\n      설문 시작: 'P'      통계 확인: 'S'      종료: 'Q'       ");
        System.out.print("\n선택: ");
        String mainButton = scan.nextLine();
        return mainButton;
    }

    // 통계 항목 선택시 출력되는 화면
    public int statisticsMenu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("                원하시는 통계 항목을 선택해주세요.            ");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("\n1. 설문자별 통계 확인하기");
        System.out.println("2. 문항별 통계 확인하기");
        System.out.println("3. 이전 메뉴로 돌아가기");
        System.out.print("\n선택: ");
        int statisticsButton = Integer.parseInt(scan.nextLine());
        System.out.println("-----------------------------------------------------------");
        return statisticsButton;
    }

    // 설문 시작시 출력되는 화면
    public String surveyMenu() {
        System.out.println("\n설문을 시작합니다.");
        System.out.print("\n이름을 입력하세요: ");
        String name = scan.nextLine();
        return name;
    }


}
