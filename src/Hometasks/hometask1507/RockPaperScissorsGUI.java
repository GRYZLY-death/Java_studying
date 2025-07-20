import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGUI extends JFrame {
    private final JLabel resultLabel;
    private final JLabel computerChoiceLabel;
    private int playerScore = 0;
    private int computerScore = 0;
    private final JLabel scoreLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RockPaperScissorsGUI().setVisible(true);
            }
        });
    }
    public RockPaperScissorsGUI() {
        setTitle("Камень, Ножницы, Бумага");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Панель с кнопками выбора
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton rockButton = new JButton("Камень");
        JButton scissorsButton = new JButton("Ножницы");
        JButton paperButton = new JButton("Бумага");

        buttonPanel.add(rockButton);
        buttonPanel.add(scissorsButton);
        buttonPanel.add(paperButton);

        // Панель с результатами
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));

        computerChoiceLabel = new JLabel("Компьютер еще не выбрал");
        computerChoiceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        resultLabel = new JLabel("Сделайте ваш выбор!");
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        scoreLabel = new JLabel("Счет: Вы 0 - 0 Компьютер");
        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        resultPanel.add(Box.createVerticalStrut(20));
        resultPanel.add(computerChoiceLabel);
        resultPanel.add(Box.createVerticalStrut(20));
        resultPanel.add(resultLabel);
        resultPanel.add(Box.createVerticalStrut(20));
        resultPanel.add(scoreLabel);

        // Добавляем панели на форму
        add(buttonPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);

        // Обработчики событий для кнопок
        ActionListener choiceListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playerChoice;
                if (e.getSource() == rockButton) {
                    playerChoice = 0;
                } else if (e.getSource() == scissorsButton) {
                    playerChoice = 1;
                } else {
                    playerChoice = 2;
                }

                playGame(playerChoice);
            }
        };

        rockButton.addActionListener(choiceListener);
        scissorsButton.addActionListener(choiceListener);
        paperButton.addActionListener(choiceListener);
    }

    private void playGame(int playerChoice) {
        Random random = new Random();
        int computerChoice = random.nextInt(3);

        // Отображаем выбор компьютера
        String[] choices = {"Камень", "Ножницы", "Бумага"};
        computerChoiceLabel.setText("Компьютер выбрал: " + choices[computerChoice]);

        // Определяем победителя
        String result;
        if (playerChoice == computerChoice) {
            result = "Ничья!";
        } else if ((playerChoice == 0 && computerChoice == 1) ||
                (playerChoice == 1 && computerChoice == 2) ||
                (playerChoice == 2 && computerChoice == 0)) {
            result = "Вы выиграли!";
            playerScore++;
        } else {
            result = "Компьютер выиграл!";
            computerScore++;
        }

        resultLabel.setText(result);
        scoreLabel.setText(String.format("Счет: Вы %d - %d Компьютер", playerScore, computerScore));
    }

}
