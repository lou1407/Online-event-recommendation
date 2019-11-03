package entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// @Getter, in industry to hide all getter method
// @Setter
// @AllArgsConstructor
// lombok

public class Item {
	private String itemId;
	private String name;
	private double rating;
	private String address;
	private Set<String> categories;
	private String imageUrl;
	private String url;
	private double distance;
	
	// Builder Pattern
	// Builder pattern builds a complex object using simple objects and using a step by step approach. 
	// It separates the construction of a complex object from its representation 
	// so that the same construction process can create different representations. 
	// We can also make the object to build immutable.
	private Item(ItemBuilder builder) {
		this.itemId = builder.itemId;
		this.name = builder.name;
		this.rating = builder.rating;
		this.address = builder.address;
		this.categories = builder.categories;
		this.imageUrl = builder.imageUrl;
		this.url = builder.url;
		this.distance = builder.distance;
	}

	public static class ItemBuilder {
		private String itemId;
		private String name;
		private double rating;
		private String address;
		private Set<String> categories;
		private String imageUrl;
		private String url;
		private double distance;

		// setter
		// source => Generate getters and setters => select setters
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setRating(double rating) {
			this.rating = rating;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setCategories(Set<String> categories) {
			this.categories = categories;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public void setDistance(double distance) {
			this.distance = distance;
		}
		
		public Item build() {
			return new Item(this);
		}

	}

	// getter
	// source => Generate Getters and Setters => select getters 
	public String getItemId() {
		return itemId;
	}
	public String getName() {
		return name;
	}
	public double getRating() {
		return rating;
	}
	public String getAddress() {
		return address;
	}
	public Set<String> getCategories() {
		return categories;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getUrl() {
		return url;
	}
	public double getDistance() {
		return distance;
	}
	

	
	// convert an Item object a JSONObject instance because in our application, 
	// frontend code cannot understand Java class, it can only understand JSON.
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("item_id", itemId);
			obj.put("name", name);
			obj.put("rating", rating);
			obj.put("address", address);
			obj.put("categories", new JSONArray(categories));
			obj.put("image_url", imageUrl);
			obj.put("url", url);
			obj.put("distance", distance);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	public static void main(String[] args) {
//		Item item = new ItemBuilder().setAddress("California").setUrl("www.google.com").setRating(5.0).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
