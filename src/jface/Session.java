package jface;

import java.util.ArrayList;

public class Session {
    public ArrayList<Entity> unsavedRecords;

    public String name;
    public String group;
    public boolean swtDone;
    public Entity activeRecord;
    public String fileName;
    public boolean isNewFile;

    public Session() {
	this.unsavedRecords = new ArrayList<>();
	this.name = "";
	this.group = "";
	this.swtDone = false;
	this.activeRecord = null;
	this.isNewFile = true;
    }

    public void addEntity(String tmpName, String tmpGroup, boolean swtDone) {
	this.unsavedRecords.add(new Entity(tmpName, tmpGroup, swtDone));
    }

    public void addEntity(Entity e) {
	this.unsavedRecords.add(e);
    }

    public ArrayList<Entity> getAllRecords() {
	return unsavedRecords;
    }

// Others
    public void clear() {
	this.unsavedRecords.clear();
	this.name = "";
	this.group = "";
	this.swtDone = false;
	this.activeRecord = null;
	this.fileName = "";
	this.isNewFile = true;
    }

    public void removeCurrentObject() {
	if (activeRecord != null && unsavedRecords.size() > 0) {
	    unsavedRecords.remove(activeRecord);
	    activeRecord = null;
	    name = "";
	    group = "";
	    swtDone = false;
	}
    }

    @Override
    public String toString() {
	StringBuilder answer = new StringBuilder();
	for (Entity s : unsavedRecords) {
	    answer.append(
		    "(Name: " + s.getName() + ", group: " + s.getGroup() + ", SWT Done: " + s.getSwtDone() + ")\n");
	}
	return answer.toString();
    }
}
