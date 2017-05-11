#Main function. Creates while-loop that iterates until game finish
def main():
    players = [['x', getUserName("x")], ['o', getUserName("o")]]
    board = [['','',''], ['','',''], ['','','']]
    iterCount = 0
    turn = 'x'
    finished = False
    while not finished:
        board = getMove(board, turn)
        printboard(board)
        if check_won(board):
            print(players[iterCount%2][1], "vant!")
            finished = True
        iterCount += 1
        turn = players[iterCount%2][0]

#Prints board to console
def printboard(board):
    for a in board:
        print(a)

#Checks if a player has won. First columns, then rows, then diagonals.
#Called after every move
def check_won(board):
    #Vertical 3 in a row
    for x in range(0,3):
        if board[0][x] == board[1][x]  == board[2][x] and len(board[0][x]) > 0:
            return True
    #Horizontal 3 in a row
    for y in range(0,3):
        if board[y][0] == board[y][1] == board[y][2] and len(board[y][0]) > 0:
            print(board[y][0], "vant (H)")
            return True
    #Diagonal 3 in a row
    #Only 2 possible diagonals; long if-statement simpler than nested loop. 
    if (board[0][0] == board[1][1] == board[2][2] and len(board[0][0]) > 0) or (board[0][2] == board[1][1] == board[2][0] and len(board[2][0]) > 0):
        print(board[1][1], "vant (D)")
        return True

#Input: T as player(x/o). Output: Username
#Loops until username is valid (Only letters)
def getUserName(T):
    while True:
        question = "Vennligst skriv inn brukernavn for " + T + "\t"
        username = input(question)
        if username.isalpha():
            return username
        else:
            print("Vennligst skriv inn gyldig brukernavn")

#Input: Wanted move, current board. // Return: Boolean
#Sees if a move is legal (if space is blank).
def legalMove(M, board):
    return board[M[0]][M[1]] == ''

#Input: Board and player.
#Makes move based on coordinate-input by user.
def getMove(board, usr):
    while True:
        try:
            move = (input("Hvilket trekk ønsker du å gjøre? (x,y)\t")).split(",")
            if len(move) != 2:
                print("Lengdefeil")
            for i in range(0,len(move)):
                move[i] = (int(move[i]))-1
            if move[0] < 3 and move[1] < 3:
                if legalMove(move, board):
                    board[move[0]][move[1]] = usr
                    return board
                else:
                    print("Dette trekket er ulovlig")
        except TypeError:
            print("Bare skriv inn tallverdier avskilt av komma")

main()