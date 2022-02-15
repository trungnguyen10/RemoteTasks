# RemoteTasks  

This is a project in Object-Oriented Design Course where the group comes up with an idea which can be potentially a product that address some problems/issues which people are pafing.  

TaskRemote is an application that allows parents to manage their kids’ activities remotely to manage screen time and promote a healthy lifestyle right from their phones. It works by giving parents many options they feel necessary to enforce healthy habits. These options include restricting certain websites or applications until proper tasks are completed, providing kids with a schedule, allowing parents to approve chore completion, and sending parents notifications about their kids’ activities. Kids can communicate task completion through the app itself or any apps that happen to be unrestricted such as text message.  

What have been done:  
A minimum prototype written in Java for Android devices that can: create children account, create task, assign task to children.  
  
Notes For Future Development:  
DB Manager is needed to stores the following records:  
Parent Account: ParentID, parent info  
Child Account: ChildID, Child info  
Task Manager: TaskMgrID, TaskMgrInfo (parent, child, task)  
  
Every change to parent, child, taskMgr has to be updated to the DB  
Ex: delete child: get parent ID who want to delete a child account, retrieve the child account will be deleted from the DB, get the list of taskMgr of that child, search for taskMgr which that child is only child assigned, delete those taskMgr from the DB, search for taskMgr which has other child accounts, remove the deleted child from the list of child of those taskMgr, update those taskMgr in the DB, delete the child account from the DB  
  
Changes may be needed for the design of TaskManager and Task:  
TaskMgr may take care of the StartTime, EndTime, ExtensionTime, …  
Generally, it will handle any fields/operations related to managing a task such as: assign task, approve task, request extension for a task,...  
Task class now only has the very basic characters of a task like task name, goal, description, reward  
