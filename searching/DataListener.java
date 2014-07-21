package searching;

public class DataListener implements Visitor {
	private Object searchData;

	public DataListener(Object searchData) {
		this.searchData = searchData;
	}

	@Override
	public boolean visit(Object data) {
		if (data == searchData) {
			return true;
		}
		return false;
	}
}
