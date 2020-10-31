import React, { useState} from 'react'
import { View, StyleSheet, Text, Image, ScrollView, FlatList  } from 'react-native'
import {Footer} from "./components/Footer";

export default class Profile extends React.Component {

    constructor(props) {
        super(props);
        
        this.state = { 
            items: [
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '1'},
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '2'},
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '3'},
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '4'},
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '5'},
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '6'},
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '7'},
                {text: 'October Java Contest', place: 'I', rate: '+132', key: '8'},
            ]
        };
    }

    render() {
        return (
            <View style={styles.container}>
                <View style={styles.profile}>
                    <View style={{alignItems: "center", paddingTop:40}}>
                        <Image style={styles.avatar}
                               source={require('../img/avatar.png')}
                               style={{ width: 120, height: 120}}
                        />
                        <Text style={styles.name}>{this.props.name}</Text>
                        <Text style={styles.bio}>{this.props.city}, Rus • {this.props.age} years</Text>
                        <Text style={styles.rate}> {this.props.rate} rate </Text>
                     </View>
                    <View style={styles.subTitle}>
                        <Text style={styles.subTitleText} >Progress</Text>
                    </View>

                    <FlatList style={styles.itemsContainer} 
                              data={this.state.items}
                              renderItem={({item}) => (
                                <View style={styles.item}>
                                    <View style={styles.itemText}>
                                        <Text style={styles.itemTitle}>{item.text}</Text>
                                        <Text style={styles.itemResult}>{item.place} Place</Text>
                                    </View>

                                    <View style={styles.itemRate}>
                                        <Text style={{color : "#14B571"}}>{item.rate} </Text>
                                    </View>
                                </View>
                                )}>
                                
                            
                    </FlatList>

                </View>

                <View style={styles.footerContainer}>
                    <Footer/>
                </View>
            </View>
        );
    }
}



const styles = StyleSheet.create ({

    container: {
        height: '100%',
        width: '100%',
        flex: 1,
        flexDirection: 'column',
    },
    profile:{
        height: 250,
        width: '100%',
        shadowColor: '#e6e6e6',
        shadowOffset: {
            width: 0,
            height: 6,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,
        flexDirection: 'column',
        flex: 1,
        elevation: 13,
    },
    avatar:{
        alignItems: 'center',
        justifyContent: 'center',
    },
    name: {
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 24,
        lineHeight: 35,
        paddingTop:5,
        paddingBottom:5
    },
    bio: {
        alignItems: 'center',
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 17,
        lineHeight: 21,
    },
    rate: {
        color: '#E15241'
    },
    subTitle: {
        //height: 300,
        width: '100%',
        flex: 0.1,
        alignItems: 'flex-start',
        justifyContent: 'center',
        lineHeight: 28,
        paddingTop: 15,
        paddingLeft:20,
        paddingBottom: 20
    },
    subTitleText: {
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 24
    },
    itemsContainer:{
        shadowOffset:{  width: 10,  height: 10,  },
        shadowColor: 'black',
        shadowOpacity: 1.0,
        flex:1,
    },
    item:{
        flexDirection:'row',
        alignItems:'center',
        paddingLeft: 20,
        paddingTop: 20,
        paddingBottom: 10,
        borderBottomColor : 'lightgrey',
        borderBottomWidth: 0.2,
        
        //flex:1
    },
    itemTitle:{
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 24
    },
    itemResult:{
        fontFamily: 'Roboto',
        fontStyle: 'normal',
        fontSize: 14
    },
    itemText:{
        flex:0.9,
        
    },
    itemRate: {
        flex: 0.2,
        justifyContent:'space-evenly',
        paddingBottom: 10
    },
    footerContainer:{
        flex: 0.07,
        shadowColor: 'black',
        shadowOffset: {
            width: 0,
            height: -3,
        },
        shadowOpacity: 0.39,
        shadowRadius: 8.30,
        elevation: 13,
        marginTop: 4,
    }
})