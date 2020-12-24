package QuanLyKho.Entity;

public class Page {
	private long totalRows; // tổng số bản ghi trong db
	private int totalPages; // tổng số trang 
	private int currentPage; // trang hiện tại
	private int recordPerPage; // số bản trên 1 trang
	private int offset; // danh sách bản ghi
	
	public Page(int recordPerpage) {
		this.recordPerPage = recordPerpage;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public int getTotalPages() {
		if (this.totalRows>0) {
			this.totalPages =(int) Math.ceil(totalRows/(double)recordPerPage);
		}
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public int getOffset() {
		if (currentPage>0) {
			offset = currentPage*recordPerPage - recordPerPage;
		}
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
	
}
