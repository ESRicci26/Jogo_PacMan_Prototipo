# 🟡 Pacman Java - Protótipo

Um protótipo simples do clássico jogo Pacman implementado em Java Swing com interface gráfica.

## ⚠️ Aviso Importante

Este é um **protótipo educacional** do jogo original Pacman. Não se trata de uma implementação completa do jogo clássico, mas sim um modelo básico que pode ser 
usado como base para desenvolvimento e aprendizado de programação em Java.

## 🎮 Sobre o Jogo

O Pacman é um dos jogos arcade mais icônicos da história, criado originalmente por Toru Iwatani e lançado pela Namco em 1980.
Esta implementação em Java Swing oferece uma versão simplificada das mecânicas básicas do jogo.

## 🎯 Objetivo

- Controle o Pacman (círculo amarelo) pelo labirinto
- Colete todos os pontos de comida (pontos brancos) espalhados pelo mapa
- Evite os demônios (quadrados vermelhos) que podem te eliminar
- Vença o jogo coletando toda a comida disponível

## 🎮 Controles

| Tecla | Ação |
|-------|------|
| **W** | Mover para cima |
| **S** | Mover para baixo |
| **A** | Mover para esquerda |
| **D** | Mover para direita |
| **Q** | Sair do jogo |

## 🏗️ Características Implementadas

### ✅ Funcionalidades Disponíveis
- Interface gráfica com Java Swing
- Controle do Pacman via teclado
- Sistema de pontuação
- Geração aleatória de labirintos
- Demônios estáticos como obstáculos
- Condições de vitória e derrota
- Contador de comida coletada
- Diálogos informativos

### 🎨 Elementos Visuais
- **Pacman**: Círculo amarelo
- **Paredes**: Blocos azuis
- **Comida**: Pontos brancos pequenos
- **Demônios**: Quadrados vermelhos
- **Espaços vazios**: Fundo preto

## 🚀 Como Executar

### Pré-requisitos
- Java Development Kit (JDK) 8 ou superior
- IDE Java (Eclipse, IntelliJ IDEA, NetBeans) ou compilador Java

### Passos para Execução
1. Clone ou baixe o código do repositório
2. Compile o arquivo `JogoPacman.java`
3. Execute a classe principal

```bash
# Compilar
javac JogoPacman.java

# Executar
java JogoPacman
```

## 📋 Regras do Jogo

### 🏆 Condições de Vitória
- **Vitória**: Colete todos os pontos de comida espalhados pelo labirinto
- A pontuação final será baseada no número de pontos coletados

### 💀 Condições de Derrota
- **Derrota**: Encoste em qualquer demônio (quadrado vermelho)
- O jogo termina imediatamente ao tocar um demônio

### 🎯 Sistema de Pontuação
- Cada ponto de comida coletado = +1 ponto
- Pontuação máxima varia conforme a geração aleatória do mapa

## 🔧 Arquitetura do Código

### Estrutura Principal
```java
public class JogoPacman extends JPanel implements KeyListener
```

### Componentes Principais
- **Inicialização**: Geração do labirinto e posicionamento dos elementos
- **Renderização**: Desenho gráfico dos elementos na tela
- **Controle**: Captura e processamento das teclas
- **Lógica**: Movimentação, colisões e condições de jogo

### Constantes do Jogo
- **Dimensões**: 40x20 células
- **Tamanho das células**: 20x20 pixels
- **Elementos**: Pacman, paredes, comida, demônios

## 🚧 Limitações do Protótipo

### Funcionalidades Não Implementadas
- **Demônios móveis**: Os demônios são estáticos
- **Inteligência artificial**: Não há perseguição ao jogador
- **Power pellets**: Não há itens especiais para derrotar demônios
- **Múltiplas fases**: Apenas um nível disponível
- **Efeitos sonoros**: Sem áudio
- **Animações**: Sprites estáticos
- **Fantasmas coloridos**: Todos os demônios são iguais
- **Túneis laterais**: Não há passagens entre as bordas
- **Frutas bônus**: Sem itens especiais de pontuação

## 💡 Possíveis Melhorias

### Sugestões para Desenvolvimento
1. **Implementar movimento dos demônios** com diferentes comportamentos
2. **Adicionar power pellets** para temporariamente derrotar demônios
3. **Criar múltiplas fases** com layouts diferentes
4. **Implementar sistema de vidas** do jogador
5. **Adicionar efeitos sonoros** e música de fundo
6. **Criar animações** para sprites
7. **Implementar diferentes tipos de demônios** com cores e comportamentos únicos
8. **Adicionar sistema de high score** persistente
9. **Criar túneis** nas bordas do labirinto
10. **Implementar frutas bônus** com pontuação especial

## 🎓 Propósito Educacional

Este protótipo foi desenvolvido como material de estudo e demonstração de conceitos de programação, incluindo:

- Programação orientada a objetos em Java
- Interfaces gráficas com Java Swing
- Captura de eventos de teclado
- Algoritmos de geração de labirintos
- Lógica de jogos 2D
- Estruturas de dados bidimensionais

## 📄 Licença

Este projeto é disponibilizado como material educacional. Sinta-se livre para usar, modificar e distribuir para fins de aprendizado.

## 🤝 Contribuições

Contribuições são bem-vindas! Este protótipo serve como base para implementações mais completas. Algumas áreas que podem ser exploradas:

- Implementação de IA para os demônios
- Sistema de fases progressivas
- Melhorias na interface gráfica
- Otimizações de performance
- Testes unitários

## 📞 Suporte

Para dúvidas sobre implementação ou sugestões de melhorias, abra uma issue no repositório.

---

**Nota**: Este é um projeto educacional e não tem afiliação com a Namco ou detentores dos direitos do Pacman original.
