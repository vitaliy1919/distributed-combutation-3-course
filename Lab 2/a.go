package main

import (
	"fmt"
	"math/rand"
	"time"
)

func checkAreaForBear(area [][]bool, xMin, xMax int, yMin, yMax int, result chan bool, i int) {
	fmt.Print("Goroutine ", i, ": checking area: (", xMin, ":", xMax, "), (", yMin, ":", yMax, ")\n")
	//time.Sleep(time.Second)
	for i := xMin; i < xMax; i++ {
		for j := yMin; j < yMax; j++ {
			if area[i][j] {
				result <- true
				return
			}
		}
	}
	result <- false
}

func main() {
	var n, m int = 100, 100
	var forestStatus = make([][]bool, n)
	for i := 0; i < n; i++ {
		forestStatus[i] = make([]bool, m)
	}

	r := rand.New(rand.NewSource(time.Now().UnixNano()))

	var xBear, yBear int = r.Intn(n), r.Intn(m)
	forestStatus[xBear][yBear] = true
	fmt.Print("Bear is here: (", xBear, ":", yBear, ")\n")
	var numberOfHives = 4
	var numberOfAreas = 10
	var chanels = make([]chan bool, numberOfHives)
	var curX, curY int = 0, 0
	var done = false
	var areaH int = n / numberOfAreas
	var areaW int = m / numberOfAreas
	for i := 0; i < numberOfHives; i++ {
		chanels[i] = make(chan bool)
		go checkAreaForBear(forestStatus, curX, curX+areaH, curY, curY+areaW, chanels[i], i)
		if curX+areaH < n {
			curX += areaH
		} else {
			curX = 0
			curY += areaW
		}
	}
	for curX < n && curY < m && !done {
		for i := 0; i < numberOfHives; i++ {
			select {
			case res := <-chanels[i]:
				//fmt.Println("Here")
				if res {
					done = true
					fmt.Println("bear was punished!!!!")
					continue
				} else {
					go checkAreaForBear(forestStatus, curX, curX+areaH, curY, curY+areaW, chanels[i], i)
					if curX+areaH < n {
						curX += areaH
					} else {
						curX = 0
						curY += areaW
					}
				}
			default:
				//fmt.Println("Default")

			}
		}
	}

}
