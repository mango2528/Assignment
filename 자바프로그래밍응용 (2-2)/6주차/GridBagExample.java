import javax.swing.*;
import java.awt.*;

public class GridBagExample extends JFrame {

    public GridBagExample() {
        setTitle("GridBagLayout 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // 1. 레이아웃 설정
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 2. 버튼 생성
        JButton btn1 = new JButton("버튼 1");
        JButton btn2 = new JButton("버튼 2");
        JButton btn3 = new JButton("긴 버튼 (가로 합치기)");
        JButton btn4 = new JButton("3");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        // 3. 첫 번째 버튼 배치 (0행, 0열)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH; // 셀 크기에 맞게 채우기
        gbc.insets = new Insets(5, 5, 5, 5); // 바깥 여백 5픽셀
        add(btn1, gbc);

        // 4. 두 번째 버튼 배치 (0행, 1열)
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(btn2, gbc);

        // 5. 세 번째 버튼 배치 (1행, 0열부터 2칸 가로 병합)
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // 가로로 2개 셀 합치기
        gbc.weightx = 0; // 가로 공간 확장 가중치 부여
        add(btn3, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 2; // 가로로 2개 셀 합치기
        gbc.weighty = 1; // 가로 공간 확장 가중치 부여
        add(btn4, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1; // 가로로 2개 셀 합치기
        gbc.weightx = 0; // 가로 공간 확장 가중치 부여
        add(btn5, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(btn6, gbc);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridBagExample();
    }
}