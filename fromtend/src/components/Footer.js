import React from 'react'
import { View, StyleSheet, Text, Image  } from 'react-native'
import { TouchableOpacity } from 'react-native-gesture-handler';
import { Actions } from 'react-native-router-flux';


export default class Footer extends React.Component {


    onChatpress(){
        Actions.toChat('Ivan Ivanov');
    }

    render() {
        return (
            <View style={styles.footerContainer}>
                <TouchableOpacity style={styles.item} >
                    <Image
                        source={require('../../img/events.png')}
                        style={styles.image}
                    />

                </TouchableOpacity  >
                <TouchableOpacity style={styles.item} onPress={this.onChatpress.bind(this)}>
                    <Image
                        source={require('../../img/messages.png')}
                        style={styles.image}
                    />

                </TouchableOpacity>
                <TouchableOpacity style={styles.item}>
                    <Image
                        source={require('../../img/contest.png')}
                        style={styles.image}
                    />

                </TouchableOpacity>
                <TouchableOpacity style={styles.item} onPress={this.onChatpress}>

                    <Image
                        source={require('../../img/profile.png')}
                        style={styles.image}
                    />
                </TouchableOpacity>
            </View>
        );
    }
}


const styles = StyleSheet.create ({
    footerContainer: {
        height: '100%',
        width: '100%',
        flexDirection: "row",
        //position: 'absolute',

        //bottom:10,
        justifyContent: 'space-around',
        alignItems: 'center',
    },
    item: {
        flex: 1,
        //padding: 10,
        flexDirection: "row",
        alignItems:'center',
        justifyContent: 'center',
        height:'100%',
        width: '100%',
    },
    image: {
        flex: .7,
        width: 34,
        height: 34,
        resizeMode: 'contain'
    }

})