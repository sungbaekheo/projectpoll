import java.util.Scanner;

public class PollsPrintMenu {

    Scanner scan = new Scanner(System.in);

    public String mainMenu() {
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        System.out.println("        백화점 환경 개선을 위한 이용 고객 대상 설문조사        ");
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("\n\n              실행하려는 메뉴를 선택해주세요.");
        System.out.println("\n      설문 시작: 'P'      통계 확인: 'S'      종료: 'Q'       ");
        System.out.print("\n선택: ");
        String button = scan.nextLine();
        return button;
    }
}
