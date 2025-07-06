package javaricci.com.br;

import javax.swing.*;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class JogoPacman extends JPanel implements KeyListener {
	private static final long serialVersionUID = 1L;
	
	// Todos os elementos a serem utilizados
    // Declarados aqui
    private static final int LARGURA = 40;
    private static final int ALTURA = 20;
    private static final int TAMANHO_CELULA = 20;
    private static final char PACMAN = 'C';
    private static final char PAREDE = '#';
    private static final char COMIDA = '.';
    private static final char VAZIO = ' ';
    private static final char DEMONIO = 'X';
    
    // Variáveis Globais são
    // Declaradas aqui
    private int resultado = 0;
    private int pontuacao = 0;
    private int pacman_x, pacman_y;
    private char[][] tabuleiro;
    private int comida = 0;
    private int atual = 0;
    private int comidaTotal = 0;
    private Random random = new Random();
    private JFrame janela;
    private JLabel labelPontuacao;
    private JLabel labelComidaTotal;
    private JLabel labelComidaConsumida;
    private JLabel labelInstrucoes;
    
    public JogoPacman() {
        tabuleiro = new char[ALTURA][LARGURA];
        inicializar();
        configurarInterface();
    }
    
    private void configurarInterface() {
        janela = new JFrame("Jogo Pacman");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(new BorderLayout());
        
        // Painel de informações
        JPanel painelInfo = new JPanel(new GridLayout(4, 1));
        labelPontuacao = new JLabel("Pontuação: " + pontuacao);
        labelComidaTotal = new JLabel("Total de Comida: " + comidaTotal);
        labelComidaConsumida = new JLabel("Comida Consumida: " + atual);
        labelInstrucoes = new JLabel("Use WASD para mover, Q para sair");
        
        painelInfo.add(labelPontuacao);
        painelInfo.add(labelComidaTotal);
        painelInfo.add(labelComidaConsumida);
        painelInfo.add(labelInstrucoes);
        
        // Configurar painel do jogo
        this.setPreferredSize(new Dimension(LARGURA * TAMANHO_CELULA, ALTURA * TAMANHO_CELULA));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(this);
        
        janela.add(painelInfo, BorderLayout.NORTH);
        janela.add(this, BorderLayout.CENTER);
        janela.pack();
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
        // Mostrar diálogo de início
        int opcao = JOptionPane.showConfirmDialog(janela, 
            "Bem-vindo ao Pacman!\n\nControles:\n" +
            "W - Cima\nS - Baixo\nA - Esquerda\nD - Direita\nQ - Sair\n\n" +
            "Deseja começar o jogo?", 
            "Pacman", 
            JOptionPane.YES_NO_OPTION);
        
        if (opcao != JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
    
    private void inicializar() {
        // Colocando Paredes como limite no Jogo
        for (int i = 0; i < ALTURA; i++) {
            for (int j = 0; j < LARGURA; j++) {
                if (i == 0 || j == LARGURA - 1 || j == 0 || i == ALTURA - 1) {
                    tabuleiro[i][j] = PAREDE;
                } else {
                    tabuleiro[i][j] = VAZIO;
                }
            }
        }
        
        // Colocando Paredes dentro do Jogo
        int contador = 50;
        while (contador != 0) {
            int i = random.nextInt(ALTURA);
            int j = random.nextInt(LARGURA);
            
            if (tabuleiro[i][j] != PAREDE && tabuleiro[i][j] != PACMAN) {
                tabuleiro[i][j] = PAREDE;
                contador--;
            }
        }
        
        int valor = 5;
        while (valor-- > 0) {
            int linha = random.nextInt(ALTURA);
            for (int j = 3; j < LARGURA - 3; j++) {
                if (tabuleiro[linha][j] != PAREDE && tabuleiro[linha][j] != PACMAN) {
                    tabuleiro[linha][j] = PAREDE;
                }
            }
        }
        
        // Colocando Demônios no Jogo
        contador = 10;
        while (contador != 0) {
            int i = random.nextInt(ALTURA);
            int j = random.nextInt(LARGURA);
            
            if (tabuleiro[i][j] != PAREDE && tabuleiro[i][j] != PACMAN) {
                tabuleiro[i][j] = DEMONIO;
                contador--;
            }
        }
        
        // Cursor no Centro
        pacman_x = LARGURA / 2;
        pacman_y = ALTURA / 2;
        tabuleiro[pacman_y][pacman_x] = PACMAN;
        
        // Pontos Colocados
        for (int i = 0; i < ALTURA; i++) {
            for (int j = 0; j < LARGURA; j++) {
                if (i % 2 == 0 && j % 2 == 0 
                    && tabuleiro[i][j] != PAREDE 
                    && tabuleiro[i][j] != DEMONIO 
                    && tabuleiro[i][j] != PACMAN) {
                    
                    tabuleiro[i][j] = COMIDA;
                    comida++;
                }
            }
        }
        
        comida -= 35;
        comidaTotal = comida;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Desenhando Todos os elementos na tela
        for (int i = 0; i < ALTURA; i++) {
            for (int j = 0; j < LARGURA; j++) {
                int x = j * TAMANHO_CELULA;
                int y = i * TAMANHO_CELULA;
                
                switch (tabuleiro[i][j]) {
                    case PAREDE:
                        g.setColor(Color.BLUE);
                        g.fillRect(x, y, TAMANHO_CELULA, TAMANHO_CELULA);
                        break;
                    case PACMAN:
                        g.setColor(Color.YELLOW);
                        g.fillOval(x + 2, y + 2, TAMANHO_CELULA - 4, TAMANHO_CELULA - 4);
                        break;
                    case COMIDA:
                        g.setColor(Color.WHITE);
                        g.fillOval(x + 8, y + 8, 4, 4);
                        break;
                    case DEMONIO:
                        g.setColor(Color.RED);
                        g.fillRect(x + 2, y + 2, TAMANHO_CELULA - 4, TAMANHO_CELULA - 4);
                        break;
                    case VAZIO:
                        // Deixar preto (cor de fundo)
                        break;
                }
            }
        }
    }
    
    private void atualizarInterface() {
        labelPontuacao.setText("Pontuação: " + pontuacao);
        labelComidaTotal.setText("Total de Comida: " + comidaTotal);
        labelComidaConsumida.setText("Comida Consumida: " + atual);
        repaint();
    }
    
    // Função permite mover o Cursor
    private void mover(int mover_x, int mover_y) {
        int x = pacman_x + mover_x;
        int y = pacman_y + mover_y;
        
        if (x >= 0 && x < LARGURA && y >= 0 && y < ALTURA && tabuleiro[y][x] != PAREDE) {
            if (tabuleiro[y][x] == COMIDA) {
                pontuacao++;
                comida--;
                atual++;
                if (comida == 0) {
                    resultado = 2;
                    return;
                }
            } else if (tabuleiro[y][x] == DEMONIO) {
                resultado = 1;
            }
            
            tabuleiro[pacman_y][pacman_x] = VAZIO;
            pacman_x = x;
            pacman_y = y;
            tabuleiro[pacman_y][pacman_x] = PACMAN;
        }
    }
    
    private void verificarEstadoJogo() {
        if (resultado == 1) {
            JOptionPane.showMessageDialog(janela, 
                "Fim de Jogo! Morto por Demônio\nSua Pontuação: " + pontuacao,
                "Fim de Jogo", 
                JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        
        if (resultado == 2) {
            JOptionPane.showMessageDialog(janela, 
                "Você Venceu!\nSua Pontuação: " + pontuacao,
                "Vitória", 
                JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        char tecla = Character.toLowerCase(e.getKeyChar());
        
        // Movendo De acordo com o
        // caractere de entrada
        switch (tecla) {
            case 'w':
                mover(0, -1);
                break;
            case 's':
                mover(0, 1);
                break;
            case 'a':
                mover(-1, 0);
                break;
            case 'd':
                mover(1, 0);
                break;
            case 'q':
                int opcao = JOptionPane.showConfirmDialog(janela, 
                    "Tem certeza que deseja sair?\nSua Pontuação: " + pontuacao,
                    "Sair do Jogo", 
                    JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                return;
        }
        
        atualizarInterface();
        verificarEstadoJogo();
    }
    
    @Override
    public void keyReleased(KeyEvent e) {}
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    // Função Principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JogoPacman();
        });
    }
}