## Table of Contents

1. [Learning outcomes](#learning-outcomes)
2. [High-level overview & motivation](#high-level-overview--motivation)
3. [Memory classifications](#memory-classifications)
4. [Memory hierarchy](#memory-hierarchy)
5. [Main (Primary) memories](#main-primary-memories)

   * [Volatile vs Non-volatile](#volatile-vs-non-volatile)
   * [RAM: SRAM vs DRAM and derivatives](#ram-sram-vs-dram-and-derivatives)
   * [ROM family: ROM, PROM, EPROM, EEPROM](#rom-family-rom-prom-eprom-eeprom)
   * [Associative (Content-Addressable) Memory](#associative-content-addressable-memory)
6. [Auxiliary (Secondary) memories](#auxiliary-secondary-memories)

   * [Magnetic tape, floppy, HDD, SSD/Flash](#magnetic-tape-floppy-hdd-ssdflash)
7. [Cache memory (detailed)](#cache-memory-detailed)

   * [Mapping types & associativity](#mapping-types--associativity)
   * [Write policies](#write-policies)
   * [Replacement algorithms](#replacement-algorithms)
   * [Performance: hit rate, miss penalty, EAT](#performance-hit-rate-miss-penalty-eat)
   * [Multilevel cache, inclusivity, coherence notes](#multilevel-cache-inclusivity-coherence-notes)
8. [Virtual memory (detailed)](#virtual-memory-detailed)

   * [Paging, segmentation basics](#paging-segmentation-basics)
   * [Address translation & page tables](#address-translation--page-tables)
   * [TLB (Translation Lookaside Buffer)](#tlb-translation-lookaside-buffer)
   * [Page replacement algorithms & working set](#page-replacement-algorithms--working-set)
   * [Thrashing & solutions](#thrashing--solutions)
9. [Common exam/assignment problems & worked examples](#common-examassignment-problems--worked-examples)
10. [Study tips, quick revision checklist & flashcards](#study-tips-quick-revision-checklist--flashcards)
11. [Appendix: formulas & cheat sheet](#appendix-formulas--cheat-sheet)

---

# High-level overview

Modern computer systems cannot use only one memory technology because of tradeoffs:

* **Speed:** Faster memories (SRAM, CPU registers) are expensive and physically limited.
* **Capacity:** Larger memories (DRAM, SSD, HDD) have higher density but are slower.
* **Cost per bit:** Increases down the hierarchy (registers > cache > main memory > SSD > HDD > tape).
* **Volatility:** Some memories (DRAM, SRAM) lose content when power off; others (flash, HDD) retain it.

The **memory hierarchy** balances these tradeoffs by placing fast small memories near the CPU (registers, caches) and larger, slower memories further away (DRAM, SSD, HDD), using locality (temporal & spatial) to keep the CPU fed with data.

---

# Memory classifications

**By purpose / position**

* **Primary (Main) memory:** Directly accessible by CPU (e.g., RAM, ROM, cache in some contexts).
* **Secondary (Auxiliary) memory:** Not directly addressed by CPU (often block/sector-based I/O) — HDD, SSD, tape.
* **Tertiary / offline:** Removable media, backups.

**By volatility**

* **Volatile:** Loses data when power off — SRAM, DRAM.
* **Non-volatile:** Retains data — ROM, Flash (EEPROM), HDD, tape.

**By access method**

* **Random access:** Any location can be directly accessed in roughly constant time — RAM.
* **Sequential access:** Must read sequentially to reach data — magnetic tape.

**By organization**

* **Addressable vs content-addressable:** Most memories are addressable (address → data). Associative / CAM returns address or data by content.

---

# Memory hierarchy

Typical pyramid (top = fastest / smallest / most expensive per bit):

```
CPU Registers
  ↓
L1 Cache (split I/D often)
  ↓
L2 Cache
  ↓
L3 Cache (shared)
  ↓
Main Memory (DRAM)
  ↓
Block storage (SSD / HDD)
  ↓
Archival (tape, cloud object storage)
```

**Key relationships**

* Speed decreases downwards, capacity increases.
* Access time: Register (≈0.3 ns) < L1 (≈1–4 ns) < L2 (≈4–12 ns) < DRAM (≈50–100 ns) < SSD/HDD (µs–ms). *(Numbers are illustrative.)*
* Effective system performance depends on hit rates at higher levels and miss penalties.

---

# Main (Primary) memories

## Volatile vs Non-volatile (recap)

* **Volatile:** DRAM (needs refresh), SRAM (static).
* **Non-volatile:** ROM types, Flash/EEPROM.

## RAM: SRAM vs DRAM and derivatives

### SRAM (Static RAM)

* **Cell:** 6-transistor flip-flop (no refresh).
* **Speed:** Very fast (used in CPU caches).
* **Density:** Low (expensive).
* **Power:** Consumes power while idle; lower refresh complexity.
* **Used for:** L1/L2 caches, small fast on-chip memory.

### DRAM (Dynamic RAM)

* **Cell:** One capacitor + one transistor; stores charge; must be refreshed periodically.
* **Speed:** Slower than SRAM, but faster than disk.
* **Density:** High (cheaper per bit).
* **Variants:**

  * **SDRAM** — Synchronous DRAM (clocked).
  * **DDR SDRAM** — Double Data Rate (DDR, DDR2, DDR3, DDR4, DDR5): transfers per clock edge improvements.
* **Used for:** Main system memory (RAM).

### Key DRAM concepts

* **Refresh interval:** Capacitor leaks; periodic refresh required (ms-level).
* **Row-buffer:** DRAM organized into rows & columns — row buffer hits speed up access (row buffer locality).
* **Memory channels, ranks, banks:** Important for throughput & parallelism.

## ROM family: ROM, PROM, EPROM, EEPROM

* **ROM (Read-Only Memory):** Programmed during manufacturing, non-volatile, not normally writable.
* **PROM (Programmable ROM):** One-time programmable (fuses or antifuses); irreversible after programming.
* **EPROM (Erasable PROM):** Can be erased (usually by UV light) and reprogrammed — older tech.
* **EEPROM (Electrically Erasable PROM):** Can be erased electrically and reprogrammed in-circuit; basis of Flash memory.
* **Flash:** NAND/NOR architectures for mass storage (NAND for SSDs, NOR for code execution in devices).

## Associative Memory (Content-Addressable Memory — CAM)

* **Function:** Access memory by content → returns matching address or data. Useful for searches (e.g., network routers for L2 forwarding).
* **Characteristic:** Parallel comparison of input against all stored words; very fast but expensive and power-hungry.
* **Use-cases:** TLBs (small CAM-like structures), routing tables, cache tag matching (conceptually).

---

# Auxiliary (Secondary) memories

## Overview: roles & properties

Secondary memory provides non-volatile larger-capacity storage at lower cost/bit. Tradeoffs: latency, throughput, random vs sequential access cost.

### Magnetic Tape

* **Access:** Sequential. Very cheap per GB. High latency for random access.
* **Use:** Backups, archival.

### Floppy Disk (historical)

* **Low capacity**, removable, mechanical. Largely obsolete. Good to know historically.

### Hard Disk Drive (HDD)

* **Mechanics:** Rotating platters + read/write heads.
* **Access:** Random but with high latency due to seek + rotational delay.
* **Throughput:** Good for large sequential I/O.
* **Cost/GB:** Lower than SSD.
* **Durability:** Mechanical wear and shock sensitivity.

### Flash Memory / SSD

* **No moving parts**, electrically erasable (NAND flash).
* **Access:** Much lower latency and higher IOPS than HDD for random I/O.
* **Endurance:** Limited program/erase cycles per block; wear leveling required.
* **Performance caveats:** Garbage collection, write amplification.
* **Use:** OS drives, mobile storage, embedded systems.

---

# Cache memory (detailed)

Cache bridges CPU and main memory. It stores copies of frequently used memory blocks (cache lines) to reduce average access time.

## Cache anatomy & terminology

* **Line / block:** Contiguous bytes moved between memory and cache (commonly 32–256 bytes).
* **Tag, index, offset:** Parts of an address for mapping.
* **Hit:** Requested data found in cache.
* **Miss:** Not found — must fetch from lower level (miss penalty).

  * **Compulsory miss:** First reference to a block.
  * **Capacity miss:** Cache too small.
  * **Conflict miss:** Mapping collisions (poorer in direct-mapped).

## Mapping types & associativity

### Direct-mapped

* Each memory block maps to exactly one cache line (index).
* **Pros:** Simple, fast.
* **Cons:** Many conflict misses.

### Fully associative

* A memory block can be placed in any cache line.
* **Pros:** Minimal conflict misses.
* **Cons:** Expensive tag comparisons (requires parallel comparators), slower.

### Set-associative (common compromise)

* Cache divided into sets; each set holds `k` lines (k-way set assoc).
* `k = 1` → direct-mapped; `k = number_of_lines` → fully associative.
* Common values: 2-way, 4-way, 8-way.

**Example mapping breakdown (32-bit address):**

```
| tag (high bits) | index (log2 num sets) | offset (log2 block_size) |
```

## Write policies

### Write-through

* Writes update cache and immediately update lower memory.
* **Pros:** Simple, ensures memory coherence.
* **Cons:** Higher memory traffic.

### Write-back (copy-back)

* Writes update cached line and mark it dirty; lower memory updated only when line is evicted.
* **Pros:** Lower write traffic.
* **Cons:** Must track dirty bits, more complex, possible higher latency on eviction.

## Replacement algorithms

* **LRU (Least Recently Used):** Replace block not used for longest time. Good performance, more overhead for high associativity.
* **FIFO (First-In First-Out):** Simpler; older blocks evicted.
* **LFU (Least Frequently Used):** Evict least accessed.
* **Random:** Low overhead; surprisingly effective in many scenarios.
* **Pseudo-LRU:** Approximation of LRU with lower overhead.

## Performance: hit rate, miss penalty, Effective Access Time (EAT)

**Definitions**

* `h` = hit ratio (fraction of accesses served by cache)
* `Tc` = cache access time
* `Tm` = main memory access time (on miss)
* `miss_penalty` = additional time to service miss

**Simple EAT formula (single-level):**

```
EAT = h * Tc + (1 - h) * (Tc + miss_penalty)
```

If `miss_penalty ≈ Tm` (ignoring cache fill time), then:

```
EAT = Tc + (1 - h) * miss_penalty
```

**Multilevel cache (2-level):**
Let `h1` be L1 hit ratio, `Tc1`, `Tc2` access times and `m1 = (1 - h1)` L1 miss rate; `h2` be L2 hit ratio *given* L1 miss. Then:

```
EAT = Tc1 + m1 * (Tc2 + m2 * Tm)
```

where `m2 = (1 - h2)`.

**Example (numbers):**

* `Tc1 = 1 ns`, `Tc2 = 5 ns`, `Tm = 100 ns`, `h1 = 0.95`, `h2 = 0.9` (on L1 misses)
* `m1 = 0.05` → EAT = `1 + 0.05 * (5 + 0.1 * 100) = 1 + 0.05 * (5 + 10) = 1 + 0.05 * 15 = 1 + 0.75 = 1.75 ns`.

## Multilevel cache, inclusivity, coherence notes

* **Inclusive cache:** Higher-level caches contain a superset of lower-level contents (L3 includes L2 lines). Easier coherence invalidation but may waste capacity.
* **Exclusive cache:** Lower-level caches contain different blocks — increases effective capacity but complex.
* **Cache coherence:** In multiprocessor systems, caches must reflect consistent memory views (protocols: MSI, MESI, MOESI, etc.). This is a wide topic; know basic states (Modified, Exclusive, Shared, Invalid).

---

# Virtual memory (detailed)

Virtual memory lets processes use virtual address space larger than physical memory by using disk to hold infrequently used pages.

## Paging & segmentation basics

* **Paging:** Fixed-size pages (e.g., 4 KB). Virtual address split into page number + offset. Page table maps virtual page → physical frame or disk.
* **Segmentation:** Variable-sized logical segments (code, stack, heap) with base+limit. Can be combined with paging (paged segmentation).

## Address translation & page tables

**Linear address (example)**:

```
Virtual address = [VPN | offset]
```

* **Page size (P):** e.g., 4 KB → offset = 12 bits.
* **Virtual page number (VPN):** remaining high bits.

**Page table types:**

* **Single-level page table:** Straightforward array of PTEs (Page Table Entries). Big for large virtual spaces.
* **Multi-level page table:** Hierarchical (2-level, 3-level...) — reduces memory overhead by making inner tables present only for used portions of address space.
* **Inverted page table:** One entry per physical frame, reduces memory for page table but increases search complexity.

**PTE (Page Table Entry) typically contains:**

* Frame number (physical), valid/invalid bit, dirty bit, access permissions (r/w/x), reference/accessed bit, caching flags.

## TLB (Translation Lookaside Buffer)

* Small, fast associative memory that caches recent page table translations (VPN → frame number).
* **TLB hit:** Fast translation, no page-table memory access.
* **TLB miss:** Requires one or more page table reads (multi-level) to fill TLB; may be handled in hardware or by OS.
* **Performance:** TLB hit ratio critical. EAT with TLB: `EAT = h_TLB * (Ta + Tc) + (1 - h_TLB) * (Ta + Tc + page_table_walk_time)` (Ta = address translation time, Tc = cache access). Exact formulation depends on architecture.

## Page replacement algorithms & working set

When physical memory is full, OS chooses a page to evict:

* **Optimal (Belady):** Replace page not used for longest future time — impossible in practice but good baseline.
* **FIFO:** Replace the oldest loaded page. Easy but poor performance sometimes.
* **LRU:** Replace least recently used. Good approximation of optimal.
* **Clock (second chance):** Circular list with reference bits; efficient LRU approximation.
* **LFU:** Remove least frequently used.
* **Working-set model:** Keep pages used in recent `Δ` time window; try to maintain working set size per process to avoid thrashing.

## Thrashing & solutions

* **Thrashing:** System spends most time swapping pages in/out, causing dramatic slowdown.
* **Causes:** Overcommitment of memory, poor locality, or too many processes.
* **Solutions:** Reduce multiprogramming level, increase RAM, use working-set or page-fault frequency algorithms, better locality in programs.

---

# Common exam / assignment problems & worked examples

## Example 1 — Cache mapping (direct-mapped)

**Given:** 32-bit address, cache size = 8 KB, block size = 64 B.
**Find:** number of index bits and tag bits.

**Solution:**

* Block offset = log₂(64) = 6 bits.
* Number of lines = cache_size / block_size = 8192 / 64 = 128 lines → index bits = log₂(128) = 7 bits.
* Tag bits = 32 − (index + offset) = 32 − (7 + 6) = 19 bits.

## Example 2 — Effective Access Time (single-level cache)

**Given:** `Tc = 1 ns`, `Tm = 100 ns`, `h = 0.98`.
**EAT =** `h*Tc + (1-h)*(Tc + Tm) = Tc + (1-h)*Tm = 1 + 0.02*100 = 1 + 2 = 3 ns.`

## Example 3 — Page replacement (FIFO)

* Sequence of page references and frame count; simulate replacement and count faults. (Standard classroom exercise.)

*(Include more practice problems in the repo as separate `.md` files or Jupyter notebooks if desired.)*

---

# Study tips, quick revision checklist & flashcards

## Revision checklist

* [ ] Know definitions of volatile/non-volatile, primary/secondary.
* [ ] Draw and explain the memory hierarchy.
* [ ] Compare SRAM vs DRAM and list uses.
* [ ] Write differences between PROM/EPROM/EEPROM/Flash.
* [ ] Be able to compute index/tag/offset for caches.
* [ ] Understand direct-mapped vs set-associative vs fully associative.
* [ ] Know replacement algorithms and be able to simulate one.
* [ ] Compute EAT for simple examples.
* [ ] Explain paging, multi-level page tables, and TLB effects.
* [ ] Simulate page replacement algorithms and explain thrashing.

## Flashcards (examples)

* **Q:** What is the main advantage of SRAM over DRAM?
  **A:** SRAM is faster and doesn’t require refresh, but is more expensive per bit.
* **Q:** What are the three types of cache misses?
  **A:** Compulsory, capacity, conflict.
* **Q:** What does the valid bit in a PTE indicate?
  **A:** Whether the page is present in physical memory (valid) or on disk (invalid).

---

# Appendix: formulas & cheat sheet

### Common formulas

* `block_offset = log₂(block_size_bytes)`
* `num_lines = cache_size / block_size`
* `index_bits = log₂(num_lines)`
* `tag_bits = address_bits - index_bits - offset_bits`
* `EAT (single-level) = Tc + (1 - h) * miss_penalty`
* `EAT (TLB) approx = h_TLB*(cache_access) + (1-h_TLB)*(cache_access + page_table_walk)`

### Quick comparisons

| Aspect     |     SRAM |        DRAM |                 HDD |              SSD (NAND) |
| ---------- | -------: | ----------: | ------------------: | ----------------------: |
| Volatility | Volatile |    Volatile |        Non-volatile |            Non-volatile |
| Speed      |  Highest |        Fast | Slow (ms latencies) |               Fast (µs) |
| Cost/bit   |     High |  Medium-low |                 Low |                  Medium |
| Use        |    Cache | Main memory |        Bulk storage | System drive / high I/O |

---
