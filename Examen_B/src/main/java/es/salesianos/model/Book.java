package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
	private Integer id;
	private String isbn;
	private Date editionDate;
	private String dateString;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private Integer warehouseId;
	private Integer warehouseOldId;
	private Integer warehouseNewId;
	private boolean isWarehouseOld;
	private Warehouse warehouse;
	
	
	public Book(String isbn, String editionDate, Integer warehouseId, boolean isWarehouseOld) {
		setIsbn(isbn);
		setEditionDate(editionDate);
		setWarehouseId(warehouseId);
		setWarehouseOld(isWarehouseOld);
	}
	
	public Book(String isbn, String editionDate, Warehouse warehouse) {
		setIsbn(isbn);
		setEditionDate(editionDate);
		setWarehouseId(warehouse.getId());
		setWarehouseOld(warehouse.isOld());
	}
	
	public Book(Integer id, String isbn, String editionDate, Warehouse warehouse) {
		this(isbn, editionDate, warehouse);
		setId(id);
	}
	
	public Book(Integer id, String isbn, String editionDate, Integer almacen_old, Integer almacen_new) {
		boolean isOld = almacen_old != 0;
		Integer almacenId = (isOld) ? almacen_old : almacen_new;
		setId(id);
		setIsbn(isbn);
		setEditionDate(editionDate);
		setWarehouseId(almacenId);
		setWarehouseOld(isOld);
	}
	
	public Book() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getShortDate() {
		Date fecha = getEditionDate();
		String day = (fecha.getDate() >= 10) ? String.format("%s", fecha.getDate()) : String.format("0%s", fecha.getDate());
		String month = ((fecha.getMonth()+1) < 10) ? String.format("0%s", fecha.getMonth()+1) : String.format("%s", fecha.getMonth()+1);
	
		String format = String.format("%s-%s-%s", fecha.getYear()+1900, month, day);
		return format;
	}
	
	public Date getEditionDate() {
		return editionDate;
	}

	public void setEditionDate(String editionDate) {
		try {
			this.editionDate = sdf.parse(editionDate);
		} catch (ParseException e) {
			this.editionDate = new Date();
		}
	}
	
	public void setEditionDate(Date editionDate) {
		this.editionDate = editionDate;
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Integer getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(Integer warehouseId) {
		this.warehouseId = warehouseId;
	}

	public boolean isWarehouseOld() {
		return isWarehouseOld;
	}

	public void setWarehouseOld(boolean isWarehouseOld) {
		this.isWarehouseOld = isWarehouseOld;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public Integer getWarehouseOldId() {
		return warehouseOldId;
	}

	public void setWarehouseOldId(Integer warehouseOldId) {
		this.warehouseOldId = warehouseOldId;
	}

	public Integer getWarehouseNewId() {
		return warehouseNewId;
	}

	public void setWarehouseNewId(Integer warehouseNewId) {
		this.warehouseNewId = warehouseNewId;
	}
}
