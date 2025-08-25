# 🧵 Java Multithreading – Execution Scenarios

This repository demonstrates 4 classic multithreading use cases in Java.  
All cases are executed from a main runner file:  
[`_4_ThreadExecutionScenarios.java`](../_4_ThreadExecutionScenarios.java)

---

## ✅ Scenarios Covered

### 1. **Single Task from a Single Thread**
- One thread performs **one task**.
- A class extends `Thread`, overrides the `run()` method, and is executed using `start()`.
- **Example**: A thread printing a message in a loop.

> 💡 Method used: `singleTaskSingleThread()`

---

### 2. **Single Task from Multiple Threads**
- Multiple threads execute the **same task** concurrently.
- The same task (e.g., a print loop) is executed using **multiple thread instances**.

> 💡 Method used: `singleTaskMultipleThreads()`

---

### 3. **Multiple Tasks from a Single Thread** (⚠️ *Not recommended for multithreading*)
- A **single thread** performs multiple tasks **sequentially**.
- Demonstrated using multiple methods called from the same thread (e.g., `main()`).

> 🚫 This is **not a true multithreading use case** – no parallelism.
> 
> Useful for understanding the contrast with real multithreading, but not suitable for concurrent systems like media players, where simultaneous task execution is needed.

> 💡 Method used: `multipleTasksSingleThread()`

---

### 4. **Multiple Tasks from Multiple Threads**
- Different threads perform **different tasks**, concurrently.
- Each thread is implemented using a separate class (extending `Thread`) with a unique `run()` logic.

> 💡 Methods used: `multipleTasksMultipleThreads()`  
> 📁 Classes used:
> - `MultipleTasksMultipleThreads.java`
> - `MultipleTasksMultipleThreads2.java`
> - `MultipleTasksMultipleThreads3.java`

---

## 🔍 Code Structure

Each scenario is implemented as a method, making it easier to call and test individually from the `main()` method.

```java
public static void singleTaskSingleThread() { ... }

public static void singleTaskMultipleThreads() { ... }

public static void multipleTasksSingleThread() { ... }

public static void multipleTasksMultipleThreads() { ... }
```

# 🧠 Notes About Threads & `main()`

- The `main()` method runs in the **main thread**, which is created by the JVM automatically.
- It is the **entry point** of all Java applications.
- Even if you don't create custom threads, the **main thread always exists**.
- For clarity, we ignore the **main thread’s role** in the multithreading logic shown here.

---

# 🔄 Sample Output (Case 4)
```
Task -1 From multipleTasksMultipleThreads Thread.
Task -2 From multipleTasksMultipleThreads2 Thread.
Task -3 From MultipleTasksMultipleThreads3 Thread.
Loop from Thread-1 : value  ---> 1
Loop from Thread-1 : value  ---> 2
Loop from Thread-1 : value  ---> 3
Loop from Thread-1 : value  ---> 4
Loop from Thread-3 : value  ---> 100
Loop from Thread-3 : value  ---> 200
Loop from Thread-3 : value  ---> 300
Loop from Thread-3 : value  ---> 400
Loop from Thread-2 : value  ---> 10
Loop from Thread-2 : value  ---> 20
Loop from Thread-2 : value  ---> 30
Loop from Thread-2 : value  ---> 40

NOTE: See we have called thread 1, 2, and then 3 but thread executed 1 , 3 and then 2. If you run same program you could see 2,3 and then 1 or 1, 2, then 3.
            they all executing in parallel.

  ===>  WHICH thread will execute 1st we can't guarantee because it decided by JVM/ThreadSchedular etc. In future will look in detail how we can prioritize the thread.

```


---

> 🧠 **Note**: Thread execution order is **not guaranteed**.  
> The **JVM** and **Thread Scheduler** determine which thread runs first or faster.

---

# ❓ FAQ

### Why separate classes for each task/thread?

Each thread requires its own logic in a `run()` method.  
Keeping logic in separate classes improves:

- ✅ **Modularity**
- ✅ **Readability**
- ✅ **Debugging**

While you *can* use one class with multiple methods, it **tightly couples code** and reduces clarity.

---

# 📌 Special Case: Case 3

🎥 **YouTube Explanation** (T.S: 10:00)

**Why Case 3 (multiple tasks, single thread) is limited:**

- Only **one task runs at a time** – no true multitasking.
- Not suitable for **concurrent systems** like media players, web servers, etc.
- Still, a good **foundational concept** before diving into real multithreading.

---

# 📂 Package Structure
```
day1/
├── _4_ThreadExecutionScenarios.java
└── threadexecutioncaseclasses/
├── SingleTaskSingleThread.java
├── MultipleTasksMultipleThreads.java
├── MultipleTasksMultipleThreads2.java
└── MultipleTasksMultipleThreads3.java
```

