class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:

        def hasDuplicates(list: List[str]) -> bool:
            filtered_list = [c for c in list if c != "."]
            return len(filtered_list) != len(set(filtered_list))

        if len(board) == 0:
            return True

        # check rows
        for row in board:
            if hasDuplicates(row):
                return False

        # check columns
        for j in range(0, 9):
            column = []
            for i in range(0,9):
                column.append(board[i][j])
            if hasDuplicates(column):
                return False

        # check boxes
        for i in (0, 3, 6):
            for j in (0, 3, 6):
                square = [board[x][y] for x in range(i, i + 3) for y in range(j, j + 3)]
                if hasDuplicates(square):
                    return False

        return True 


if __name__ == "__main__":
    sol = Solution()
    print(sol.isValidSudoku([
        [".",".","4",".",".",".","6","3","."],
        [".",".",".",".",".",".",".",".","."],
        ["5",".",".",".",".",".",".","9","."],
        [".",".",".","5","6",".",".",".","."],
        ["4",".","3",".",".",".",".",".","1"],
        [".",".",".","7",".",".",".",".","."],
        [".",".",".","5",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."],
        [".",".",".",".",".",".",".",".","."]]
        ))
         