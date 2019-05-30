# CS-Duke201-PercolationProject
Project using DFS, union-find structures and simulations to estimate the percolation threshold in an NxN system.

From the project description:

In this assignment, you will write a program to estimate the value of the percolation threshold via Monte Carlo simulation. In doing so, you will better understand depth-first-search, union-find structures, and the use of computer simulations for statistical inquiry. Your goal will be to explore trade-offs in several approaches to estimate the percolation threshold in an NxN system.

Given a porous landscape with water on the surface (or oil below), under what conditions will the water be able to drain through to the bottom (or the oil to gush through to the surface)? Given a composite systems comprised of randomly distributed insulating and metallic materials, what fraction of the materials need to be metallic so that the composite system is an electrical conductor? Scientists have defined an abstract process known as percolation to model such situations.

We model a percolation system using an N-by-N grid of sites. Each site is either open or blocked. A full site is an open site that can be connected to an open site in the top row via a chain of neighboring (left, right, up, down) open sites. In diagrams we color full sites blue to model water flowing from the top through the system. We say the system percolates if there is at least one full site in the bottom row. In other words, a system percolates if there is a path of open sites from the top row to the bottom row. For the porous substance example, the open sites correspond to empty space through which water might flow, so that a system that percolates lets water fill open sites, flowing from top to bottom.

For more on percolation see the Princeton Case Study.

The percolation threshold problem is: if sites are independently set to be open with probability p (and therefore blocked with probability 1 − p), what is the probability that the system percolates? In other words, in a N-by-N grid, would the system percolate if N2p randomly chosen cells are opened?  When p equals 0, the system does not percolate; when p equals 1, the system percolates. The plots below show the site vacancy probability p versus the percolation probability for 20-by-20 random grid (left) and 100-by-100 random grid (right).
When N is sufficiently large, there is a threshold value p* such that when p < p* a random N-by-N grid almost never percolates, and when p > p*, a random N-by-N grid almost always percolates. No mathematical solution for determining the percolation threshold p* has yet been derived. Your task is to write a suite of computer programs to visualize the percolation process and estimate p* using Monte Carlo techniques. As you can see above, the percolation threshold in an NxN grid is about 0.593. The size of the grid doesn't matter as your simulations will show. 
