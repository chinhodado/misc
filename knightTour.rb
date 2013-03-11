# 2D array implementation
class SparseArray
  attr_reader :hash

  def initialize
    @hash = {}
  end

  def [](key)
    hash[key] ||= {}
  end

  def rows
    hash.length
  end

  alias_method :length, :rows
end

# check if i,j are valid indexes on the chessboard
def is_safe(x, y, sol)
  return true if x >= 0 && x < 8 && y >= 0 && y < 8 && sol[x][y] == -1
  return false
end

# print solution matrix sol
def print_solution(sol)
  for x in 0...8
    for y in 0...8
      print '%3s' %  "#{sol[x][y]} "
    end
    puts
  end
end

def solveKT
  sol = SparseArray.new

  # Initialization of solution matrix
  for x in 0...8
    for y in 0...8
      sol[x][y] = -1
    end
  end


  # xMove and yMove define next move of Knight.
  # xMove is for next value of x coordinate
  # yMove is for next value of y coordinate
  xMove = [2, 1, -1, -2, -2, -1,  1,  2]
  yMove = [1, 2,  2,  1, -1, -2, -2, -1]

  # Since the Knight is initially at the first block
  sol[0][0]  = 0

  # Start from 0,0 and explore all tours using solveKTUtil()
  if !solveKTUtil(0, 0, 1, sol, xMove, yMove)
    puts 'Solution does not exist'
    return false
  else
    print_solution(sol)
    return true
  end
end

def solveKTUtil(x, y, movei, sol, xMove, yMove)
  return true if movei == 8*8
  # Try all next moves from the current coordinate x, y
  for k in 0...8
    next_x = x + xMove[k]
    next_y = y + yMove[k]
    if is_safe(next_x, next_y, sol)
      sol[next_x][next_y] = movei
      if solveKTUtil(next_x, next_y, movei+1, sol, xMove, yMove)
        return true
      else
        sol[next_x][next_y] = -1 # backtracking
      end
    end
  end
  return false
end

solveKT()
