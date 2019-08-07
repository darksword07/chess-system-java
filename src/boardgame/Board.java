package boardgame; 

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro criando tabuleiro: É necessario 1 linha e 1 coluna.");
		}
		this.rows = rows;
		this.columns = columns;
		this.pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column){
		if (!positionExists(row, column)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return pieces[row][column];
	}
	
	public void placePiece(Piece piece, Position position){
		if (thereIsAPiece(position)) {
			throw new BoardException("Já tem uma peça nessa posicao " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece piece(Position pos){
		if (!positionExists(pos)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return pieces[pos.getRow()][pos.getColumn()];
	}
	
	private boolean positionExists(int row, int column){
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position){
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position){
		if (!positionExists(position)) {
			throw new BoardException("Posição não está no tabuleiro");
		}
		return piece(position) != null;
	}
}
