package main

import (
	"fmt"
)

func main() {
	_, s := f()
	fmt.Println(s)
}

func f() (err error, s string) {
	defer func() {
		if p:=recover(); p!= nil {
			fmt.Println("yes")
			s = "111"
		}
	}()

	panic("111")
}


// func canPartition(nums []int) bool {
//     length := len(nums)
//     if length == 0{
//         return false
//     }
//     sum := 0
//     for _, item := range nums {
//         sum += item
//     }
//     // 这个就是个背包问题
//     if sum % 2 == 1{return false};
//     target := sum/2
//     res := make([]int, target+1) // 数组不是切片，也就是动态数组，除非里面写的是常量，否则就是对应动态数组
//     res[0] = 1
//     for _,item := range nums {
//         for j:= target; j>=item; j-- {
//             res[j] += res[j-item]
//         }
//     }
//     if res[target]!=0 {return true}
//     return false
// }