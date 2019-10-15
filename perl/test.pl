#!/usr/bin/perl
use strict;
use warnings FATAL => 'all';
use feature state;
# sub Hello{
#     print "Hello, World!\n";
# }
#
# # 函数调用
# Hello();


# 方法定义
sub PrintHash{
    my (%hash) = @_;

    foreach my $key ( keys %hash ){
        my $value = $hash{$key};
        print "$key : $value\n";
    }
}
my%hash = ('name' => 'runoob', 'age' => 3);

# 传递哈希
PrintHash(%hash);
