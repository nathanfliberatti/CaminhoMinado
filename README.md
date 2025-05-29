  Com um vetor (array unidimensional) de inteiros é possível implementar o
jogo descrito a seguir, que chamaremos de caminho minado. Primeiro o
usuário/jogador deverá informar o tamanho do caminho e a quantidade de
bombas, sendo que o caminho deve ter tamanho maior que 1 e o número de
bombas deve ser maior do que 0 e menor que o tamanho do caminho. 
    
O computador irá escolher posições aleatórias no caminho para colocar/esconder
as bombas, tomando o cuidado de não acrescentar mais do que 1 bomba em
uma mesma posição. 
    
No vetor de inteiros -1 representará uma posição com
bomba, 0 uma posição livre (sem bomba) 

  e, 1 uma posilççao que estava livre e foi escolhida pelo usuário (sem explodir a bomba).

   Para o usuário/jogador, inicialmente irá aparecer todas as posições do caminho como ? _ ?, 
pois ele ainda não terá escolhido nenhuma posição. 
    
  Quando o usuário/jogador escolher uma posição, se for uma posição livre (inteiro 0)
a máscara " _ " irá mudar para " x " (inteiro 1), mas caso naquela posição tenha uma bomba (inteiro -1)
irá aparecer " b " no lugar de " _ " e será o fim do jogo. Caso o usuário/jogador
tenha escolhido uma posição livre, mas do lado esquerdo ou direito tem uma
bomba deve ser impresso a mensagem "Cuidado: bomba próxima!" (por
exemplo, o computador colocou uma bomba na posição 7 do vetor e o jogador
escolheu 6 ou 8). Vale destacar que o jogador não deve poder escolher
posições indicadas com " x ". No final, deverá ser impresso "Parabéns, você
ganhou o jogo!" se o jogador atingiu a pontuação máxima ou "Game Over!",
caso contrário. Em ambos os casos será impresso a pontuação alcançada (cada
posição livre escolhida vale 1 ponto) do total de pontos possíveis, assim como
o caminho com " x " (acertos), " b " (bombas) e, se for o caso, " _ " (posições
livres). Por fim, considere que a primeira posição do caminho (índice 0 do
vetor) começa à esquerda da tela do computador.
